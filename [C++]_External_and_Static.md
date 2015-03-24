```cpp
//cExample.h
#ifndef C_EXAMPLE_H
#define C_EXAMPLE_H
extern int add(int x,int y);
#endif

//cExample.c
#include "cExample.h"
int add( int x, int y )
{
    return x + y;
}

//cppFile.cpp
extern "C" 
{
#include "cExample.h"
}
int main(int argc, char* argv[])
{
    add(2,3); 
    return 0;
}
```
