###source files:
####func.c
```cpp
int buf = 0;

void func() {
  buf = 2;
  /* Do something else */
}
```

####main.c
```cpp
#include <stdio.h>

int buf;
void func();

int main() {
  buf = 1;
  func();
  printf("%d\n", buf);
  return 0;
}
```
###compile
```bash
gcc main.c func.c
```

###output
```
2
```

###Explaination
- during compilation,tokens are
  - `strong`: function,global variable that has been initialized
  - `weak`: global variable that hasn't been initialized
- during linkage
  - The same token cannot have >=2 strong defs
  - 1 strong def and >=1 weak defs, choose the strong definition
  - >=2 weak defs, choose 1 def arbitrarily