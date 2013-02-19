
```c++
const int t = 12;
int *pt;
const int **ppt = &pt;//invalid conversion from ‘int**’ to ‘const int**’;*ppt and pt would refer to the same address, and t can be modified by *pt, violate the const property of ppt
*ppt = &t;
*pt = 15;
```