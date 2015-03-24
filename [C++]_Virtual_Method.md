``` cpp
#include<iostream>
using namespace std;
struct A{
    virtual void  foo(int a=1){
        cout<<a<<endl;
    }
};

struct B:public A{
    virtual void foo(){
        cout<<'B'<<endl;
    }
    virtual void foo(int a){
        cout<<'B'<<a<<endl;
    }
};

int main(int argc,char**argv){
    A *p = new B();
    p->foo();
    delete p;
}

//output B1
```
