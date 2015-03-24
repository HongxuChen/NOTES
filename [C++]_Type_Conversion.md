##Automatic conversion

- Promotion

```c++
void do_something(short arg){
    cout << "Doing something with a short" << endl;
} 
void do_something(int arg){
    cout << "Doing something with an int" << endl;
}
int main(int argc, char **argv){
    short val = 12;
    do_something(val); // Prints "Doing something with a short"
    do_something(val * val); // Prints "Doing something with an int"
}
```
- Numeric conversion

##Explicit type conversion (casting)
###`static_cast`(unsafe casting)

```c++
static_cast<target type>(expression)
```

- don't do _runtime checking_ of the types involved, unsafe. 
- Allow casting between _related_ types(pointers or references between Base and Derived, or between fundamental types, such as long to int or int to float)  
- Also allow cast from non-const to const
- do not allow casts between_different types_(cast between a BaseA and BaseB if they are not related would be compile error)

###`dynamic_cast`(safe downcasting)
```c++
  TYPE& dynamic_cast<TYPE&> (object);
  TYPE* dynamic_cast<TYPE*> (object);
```
- casts a datum from one _pointer_/_reference_ a of _polymorphic_ type to another
- similar to `static_cast` but performing a runtime type safety check(slower than `static_cast`,in gcc use `-fno-rtti` to turn off)
- support cross-cast,`NULL` if cast fails for _pointer_,`bad_cast` if cast fails for _reference_

```c++
struct A {
    virtual void f() { } //base class should have >=1 virtual function to tell compiler a vtable be established
  };
  struct B : public A { };
  struct C { };
  void f () {
    A a;
    B b;
    A* ap = &b;
    B* b1 = dynamic_cast<B*> (&a);  // NULL, because 'a' is not a 'B'
    B* b2 = dynamic_cast<B*> (ap);  // 'b'
    C* c = dynamic_cast<C*> (ap);   // NULL.
//  C* c = static_cast<C*> (ap);    // compile error
    A& ar = dynamic_cast<A&> (*ap); // Ok.
    B& br = dynamic_cast<B&> (*ap); // Ok.
    BB& br = dynamic_cast<B&> (a); // std::bad_cast
    C& cr = dynamic_cast<C&> (*ap); // std::bad_cast
  }
```

###`reinterpret_cast`(unsafe bitwise)

```c++
TYPE reinterpret_cast<TYPE> (object);
```

- ultimate cast, which disregards all kind of type safety, allowing you to cast anything to anything else, basically reassigning the type information of the bit pattern.
- used for non portable casting operations
- do not support different primitives type cast but can used with _reference_

```c++
int i = 0;
void *v = 0;
int c = (int)v; // valid
int d = static_cast<int>(v); // not valid, different types
int e = reinterpret_cast<int>(v); // valid, but very dangerous
int n=9;
//std::cout<<reinterpret_cast<double> (n)<<std::endl; //compile error
std::cout<<reinterpret_cast<double & > (n)<<std::endl; //1.78177e-308,not fixed value since the size of double && int
```

###`const_cast`(remove property)

```c++
TYPE* const_cast<TYPE*> (object);
TYPE& const_cast<TYPE&> (object);
```

- used to remove the _const_ or _volatile_ property([cv-qualifiers](http://en.cppreference.com/w/cpp/language/cv)) from an object
- target data type must be the same as the source type(without `const`)

```c++
class Foo {
public:
  void func() {} // a non-const member function
};
void someFunction( const Foo& f )  {
  f.func();      // compile error: cannot call a non-const 
                 // function on a const reference 
  Foo &fRef = const_cast<Foo&>(f);
  fRef.func();   // okay
}
```

###C-style cast
```c++
(TYPE)object
TYPE(object)
```
Dangerous,has all the equivalent functionality of C++ cast except `dynamic_cast`

###References:
- [Regular cast vs. static_cast vs. dynamic_cast](http://stackoverflow.com/questions/28002/regular-cast-vs-static-cast-vs-dynamic-cast/28037#28037)
- [Type Conversion] (http://en.wikibooks.org/wiki/C%2B%2B_Programming/Programming_Languages/C%2B%2B/Code/Statements/Variables/Type_Casting) in Wikibook 
- [C++的四种cast操作符的区别](http://welfare.cnblogs.com/articles/336091.html)
