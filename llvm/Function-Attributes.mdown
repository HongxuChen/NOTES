- http://llvm.org/docs/LangRef.html#function-attributes
- http://gcc.gnu.org/onlinedocs/gcc/Function-Attributes.html

`readnone` when using gnu `__attribute__((const))`, the used function has this attribute

```cpp
extern int square(int n)__attribute__((const));
/*extern int square(int n);*/
int test(){
    int total = 0;
    for(int i=0;i<100;i++){
       total+=square(5)+i; 
    }
    return total;
}
```
