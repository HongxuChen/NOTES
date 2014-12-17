### clang optimization levels

```bash
-O3 : throw everything and hope it sticks
-O2 : optimized build, but should not explode in code size nor consume all resources while compiling
-O1 : optimized debug binaries, don't change the execution order but remove dead code and stuff
-O0 : don't touch it
-Os : optimize, but don't run passes that could blow up code. Try to be a bit more drastic when removing code. When in doubt, prefer small, not fast code.
-Oz : only perform optimizations that reduce code size. Don't even try to run things that could potentially increase code size.
```

###Generate executable from .bc files

```bash
llvm-ld-3.0 cast.bc -o cast_llvm /usr/lib/i386-linux-gnu/libstdc++.so.6.0.16  -native
#or
llc-3.0 cast.bc
gcc cast.s -o cast_llvm -L/usr/lib/i386-linux-gnu -lstdc++
```
