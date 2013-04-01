1. 避免不必要的函数调用  
1. 避免不必要的内存引用  
1. 节约内存（内存对齐和填充的概念）  
1. 使用无符号整数，而不是整数的，如果你知道的值将永远是否定的  
   有些处理器可以处理无符号的整数比有符号整数的运算速度要快
1. 在一个逻辑条件语句中常数项永远在左侧  
1. 在可能的情况下使用typedef替代macro。当然有时候你无法避免macro，但是typedef更
   好  
1. 确保声明和定义是静态的，除非您希望从不同的文件中调用该函数  
    静态声明一个函数的优点包括  
    1. 两个或两个以上具有相同名称的静态函数，可用于在不同的文件
    1. 编译消耗减少，因为没有外部符号处理
1. 使用Memoization，以避免递归重复计算  

    ```c++
    int calc_fib (int n) {
        intval[n] , i;
        for(i = 0; i <= n; i++) {
            val[i] = -1; 
        }
        val[0] = 1;
        val[1] = 1;
        return fib(n, val);
    }
    int fib(int n, int* value)
    {
        if(value[n] != -1 ) {
            return value[n];
        }
        else{
            value[n] = fib(n - 2, value) + fib(n - 1 , value);
        }
        returnvalue[n];
    }
    ```
1. 避免悬空指针和野指针  
1. 永远记住释放你分配给程序的任何内存  
