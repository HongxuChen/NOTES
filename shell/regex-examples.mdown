##eclipse
<http://www.eclipse.org/tptp/home/downloads/installguide/gla_42/ref/rregexp.html>

- replace _cout_ with _std::cout_,use `\wcout`=>` std::cout`
- strip the header numbers of the code pasted from web:`^\s*[0-9][0-9]?:`=>` `  
Suppose the copied source are like

```cpp
...
  9  #include<iostream>
  10 using namespace std;
...
```
