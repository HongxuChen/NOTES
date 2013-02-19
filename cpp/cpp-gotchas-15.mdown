### Gotcha 15 Precedence Problems
- Precedence of Ternary operator is lower than `<<`.In the example below, the first statement would evaluate `(cout << (i == 0)` firstly, an implicit conversion to `operator void*` would take effect to the `ostream` object, a value would be generated according whether this pointer is `NULL` or not.

  ```c++
  cout << (i == 0):"zero"?"non-zero";
  cout << ((i == 0):"zero"?"non-zero");
  ```

  ```c++
  a = ++ptr->mem; # a = ++(ptr->mem);
  a = (++ptr)->mem; # a = (++ptr,ptr->mem);
  ```

- Usage of operators `->*`(no whitespace between _>_ and _*_) and `.*`

  ```c++
  class C{
  ...
  void f(int);
  int mem;
  ...
  }
  void (C::*pfmem)(int) = &C::f;
  int C::*pdmem = &C::mem;
  C *cp = new C;
  C c;
  (cp->*pfmem)(12); // cp->*pfmem(12); would fail to compile
  (c.*pfmem)(12);
  
  ```
