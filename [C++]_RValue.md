> Basically referred to [C++ Rvalue References Explained](http://thbecker.net/articles/rvalue_references/section_01.html)

# No-Name Rule

The insight: the lifespan of the variable in the right-hand-side
- If it does not have a name, it's an **rvalue**.
- If it has a name, then it's an **lvalue**.

# Reference Collapsing Rules

  ```
   A& & becomes A&
   A& && becomes A&
   A&& & becomes A&
   A&& && becomes A&&
  ```

# Template Argument Deduction Rule

  ```c++
  template<typename T>
  void foo(T&&);
  ```

1. When foo is called on an lvalue of type `A`, `T => A&`
1.  When foo is called on an rvalue of type `A`, `T => A&&`

# Move Semantics: `std::move`

  ```c++
  template<typename _Tp>
  constexpr typename std::remove_reference<_Tp>::type&& move(_Tp&& __t) noexcept {
    return static_cast<typename std::remove_reference<_Tp>::type&&>(__t);
  }
  ```

1. Turn its argument into an rvalue even if it isn't
1. No name will be generated
1. only change the type for rvalue

  ```c++
  X x;
  std::move(x);
  // is equavalent to
  static_cast<X&&>(x);
  ```

# move semantics and exceptions

1. For copy constructor and the copy assignment operator

  1. Write implementation so that they cannot throw exceptions
  1. add noexcept keyword

```c++
// Example, for std::move and `std::move_if_noexcept`
#include <iostream>
#include <utility>
struct Bad {
  Bad() {}
  Bad(Bad&&) { std::cout << "Throwing move constructor called\n"; }
  Bad(const Bad&) { std::cout << "Throwing copy constructor called\n"; }
};
struct Good {
  Good() {}
  Good(Good&&) noexcept {
    std::cout << "Non-throwing move constructor called\n";
  }
  Good(const Good&) noexcept {
    std::cout << "Non-throwing copy constructor called\n";
  }
};
int main(void) {
  Good g1;
  Bad b1;
  Good g2 = std::move_if_noexcept(g1); // move
  Good g3 = std::move(g2);  // move
  Bad b2 = std::move_if_noexcept(b1); // copy
  Bad b3 = std::move(b2); // move
}
```

# rvalue is NOT always necessary

1. [RVO](https://en.wikipedia.org/wiki/Return_value_optimization)(return value optimization) works better
1. moveable but not copyable:  `std::unique_ptr`
1. Implicit Move
1. Perfect Forwarding: `std::forward`

  ```c++
  template<typename _Tp>
    constexpr _Tp&&
  forward(typename std::remove_reference<_Tp>::type& __t) noexcept {
    return static_cast<_Tp&&>(__t);
  }
  template<typename T, typename Arg>
  shared_ptr<T> factory(Arg&& arg) {
   return shared_ptr<T>(new T(std::forward<Arg>(arg)));
  }
  /// remove_reference<S>::type& => S&
  template<class S> S&& forward(typename remove_reference<S>::type& a) noexcept {
   return static_cast<S&&>(a);
  }
  ```
    
1.  For lvalue `X x`, `factory<A>(x)` becomes

  ```c++
  shared_ptr<A> factory(X& && arg) {
   return shared_ptr<A>(new A(std::forward<X&>(arg)));
  }
  X& && forward(remove_reference<X&>::type& a) noexcept {
   return static_cast<X& &&>(a);
  }
  ```
    
  And finally
    
  ```c++
  shared_ptr<A> factory(X& arg) {
   return shared_ptr<A>(new A(std::forward<X&>(arg)));
  }
  X& std::forward(X& a) {
   return static_cast<X&>(a);
  }
  ```

2.  For rvalue `X foo()`, `factory<A>(foo())` becomes

  ```c++
  shared_ptr<A> factory(X&& arg) {
   return shared_ptr<A>(new A(std::forward<X>(arg)));
  }
  X&& forward(X& a) noexcept {
   return static_cast<X&&>(a);
  }
  ```

# Summary
1. Neither `std::move` nor `std::forward` does much, the rvalue reference semantics does.
1. [A Brief Introduction to Rvalue References](http://www.artima.com/cppsource/rvalue.html)
1. [Universal References in C++11—Scott Meyers](http://isocpp.org/blog/2012/11/universal-references-in-c11-scott-meyers)

# Rules of thumb:
1. Return by value (and rely on either copy elision or move semantics) unless you want to expose internals (like `std::vector::operator[]` returns a reference)
1. don't return an owning raw pointer (i.e., one that must be deleted)
1. don't return a const object (because that prohibits move semantics)
