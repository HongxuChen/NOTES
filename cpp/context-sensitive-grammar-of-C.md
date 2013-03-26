Here `context sensitive` is only related to the recognition of grammar(the opposite: CFG--context free grammar) and has nothing to do with semantics.
###Example 1
```cpp
int T(int y){
    return y*2;
}
{
//    typedef int T; //case 1
//    int x;  //case 2
    T(x);
}
```
- case 1, _T(x);_ is a declaration for `x` of type _int_
- case 2, _T(x);_ is a function call

###Example 2
```cpp
func((T)*x);
```
- `T` is a type => the result of deferencing `x` is cast to `func`
- `T` isn't a type => multiplication of `T` and `x`

###Example 3
```cpp
#include<stdio.h>
typedef char A;
void func() {
    printf("%d\n",sizeof(A));
    A a; /* OK - define variable a of type A */
    {
        A A; /* OK - define variable A of type A */
        printf("%c\n",A);
    }
    A *A; /* OK - define variable A, which is a pointer of type A */
    printf("%d\n",sizeof(A));
}
int main() {
    double A;/* OK - define variable A of type double */
    func();
}
```

References:  

- [The context sensitivity of C’s grammar](http://eli.thegreenplace.net/2007/11/24/the-context-sensitivity-of-cs-grammar/)  
- [Context-sensitive grammar and Context-free grammar](http://stackoverflow.com/questions/8236422/context-sensitive-grammar-and-context-free-grammar/8250104#8250104)
- [The context sensitivity of C’s grammar, revisited](http://eli.thegreenplace.net/2011/05/02/the-context-sensitivity-of-c%E2%80%99s-grammar-revisited/)
- [The type/variable name ambiguity in C++](http://eli.thegreenplace.net/2012/06/28/the-type-variable-name-ambiguity-in-c/)
