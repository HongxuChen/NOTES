###Standard File System Hierachy

```bash
prefix           /usr/bin  
exec-prefix      $prefix
bindir           $exec-prefix/bin
libdir           $exec-prefix/lib
includedir       $prefix/include
datarootdir      $prefix/share
datadir          $datarootdir
mandir           $datarootdir/man
infodir          $datarootdir/info
```
`DESTDIR` to relocate a package at install time(used with make dist)

###Configuration Variables

```bash
CC
CFLAGS
CXX
CXXFLAGS
LDFLAGS
CPPFLAGS
```
Notes: often used with `pkg-config` when mannually configuration. `llvm-config`
is a similar tool.

###rename program at install time

```
--program-prefix=PREFIX            
--program-suffix=SUFFIX
--program-transform-name=PROGRAM   #run `sed PROGRAM`, --program-transform-name="s/^/am/g" transform hello into amhello
```

###TIPS:
1. gnu `test` related:

```bash
test -z "hello" || rm -f hello  #often used in clean
test -z "CC" && CC=clang        #often in config.site
``
1. `configure --help=recursive`

Things that `make discheck` does:

1. tests VPATH builds
1. ensure `make clean`,`make distclean`,`make uninstall` don't omit files
1. checks DESTDIR works
1. runs test suite(`make check` and `make installcheck`)

###Dependency tracking
Only useful when src changes,

1. --disable-dependency-tracking
1. --enable-dependency-tracking
