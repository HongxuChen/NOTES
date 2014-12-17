###Generate executable from .bc files

```bash
llvm-ld-3.0 cast.bc -o cast_llvm /usr/lib/i386-linux-gnu/libstdc++.so.6.0.16  -native
#or
llc-3.0 cast.bc
gcc cast.s -o cast_llvm -L/usr/lib/i386-linux-gnu -lstdc++
```