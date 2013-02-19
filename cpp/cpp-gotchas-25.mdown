###Gotcha 25:`#define` Literals

```c++
#include<iostream>
#define MAX 1<<24
void f(long long i){
    std::cout<<i<<" long \n";
}
void f(unsigned i){
    std::cout<<i<<" unsigned \n";
}
void f(int i){// would always invoke this one in gcc;even if MAX=2^32
    std::cout<<i<<" int \n";
}
int main(){
    std::cout<<sizeof(int)<<"\n";            #i386,gcc ; 4
    std::cout<<sizeof(long long)<<"\n";      #i386,gcc ; 8
    f(MAX);
}
```

- a `#define` is not scoped inside a namespace(preprocess)
- In `class`, it's possible that the space for static data member will not be optimized away, and the traditional use of an enumerator is preferred for simple integral constants.

```c++
class Name { 
   // . . .
   void capitalize();
   enum { nameLen = 32 };//better
   static const int nameLen_ = 32;//not suggested
   char name_[nameLen];
};
```
