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
