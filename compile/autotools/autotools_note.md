>This is a note for learning ANU autotools, see
>http://www.lrde.epita.fr/~adl/autotools.html for details

### Standard File System Hierachy

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

### Configuration Variables

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

### rename program at install time

```
--program-prefix=PREFIX            
--program-suffix=SUFFIX
--program-transform-name=PROGRAM   #run `sed PROGRAM`, --program-transform-name="s/^/am/g" transform hello into amhello
```

### TIPS:

1. gnu `test` related:

   ```bash
   test -z "hello" || rm -f hello  #often used in clean
   test -z "CC" && CC=clang        #often in config.site
   ```

1. `configure --help=recursive` might be helpful
1. @XYZ@ is contained in `.in` files. In `Makefile.in`, it is defined by
   `automake`, other `.in` files placeholders are substituted by `config.status`.

1. Things that `make discheck` does:

   1. tests VPATH builds
   1. ensure `make clean`,`make distclean`,`make uninstall` don't omit files
   1. checks DESTDIR works
   1. runs test suite(`make check` and `make installcheck`)

### Dependency tracking
Only useful when src changes,

1. --disable-dependency-tracking
1. --enable-dependency-tracking


### Autoconf macros for prelude

1. AC_INIT(PACKAGE,VERSION,BUG-REPORT-ADDRESS)
1. AC_PREREQ(VERSION)
1. AC_CONFIG_SRCDIR(FILE)

### Program Checks

1. AC_PROC_CC, AC_PROC_CXX,...
1. AC_PROC_SED, AC_PROC_YACC, AC_PROC_LEX
1. AC_CHECK_PROGS(VAR, PROGS, [VAR-IF-NOT-FOUND])

### Action Macros

1. AC_MSG_ERROR(ERROR-DESCRIPTION, [EXIT-STATUS])
1. AC_MSG_WARN(ERROR-DESCRIPTION)
1. AC_DEFINE(VARIABLE, VALUE, DESCRIPTION)

   Outputs the following to _config.h_
   
   ```cpp
   /* DESCRIPTION */
   #define VARIABLE VALUE
   ```

1. AC_SUBST(VARIABLE, [VALUE])  

   Define $(VARIABLE) as VALUE in _makefile_
   
   
### Checking for libraries and headers

1. AC_CHECK_LIB(LIBRARY, FUNCT, [ACT-IF-FOUND], [ACT-IF-NOT])
1. AC_CHECK_HEADER(HEADER, [ACT-IF-FOUND], [ACT-IF-NOT])
1. AC_CHECK_HEASERS(HEADERS...)
1. AC_CONFIG_HEADERS(HEADER...),create _HEADER_ for all _HEADER.in_, HEADER
   contains definitions made with AC_DEFINE
1. AC_CONFIG_FILES(FILE...),FILE contains definitions made with AC_SUBST

### automake principles

1. Makefile.am -> Makefile.in, Makefile.am uses the same syntax as Makefile.in
   but usually containts only variable definitions.
1. useful options

    ```
    -Wall
    -Werror
    foreign
    1.11.1
    dist-bzip2
    tar-ustar
    ```

### VPATH build

1. source tree:`Makefile.in`, `Makefile.am`
1. build tree: `Makefile`(_config.status_ would define $(srcdir) for each Makefile)

`make` would check automake variables in both srcdir and build dirictory, but
not true for flags of tools(gcc compilation options, for instance)

### Conditional
AM_CONDITIONAL(NAME, CONDITION)

```
AM_CONDITIONAL([WANT_BAR], [test "$use_bar" == yes])
```

### Define Macros

1. AC_DEFUN(MACRO-NAME, MACRO-BODY)

Naming convention:

```
m4_             M4 and M4sugar macro
AS_             M4sh
AH_             autohead
AC_             autoconf
   AC_CHECK_    Generic checks 
   AC_FUNC_     function checks
   AC_HEADER_   header checks
   AC_PROG_     program checks
AM_             automake
AT_             autotest
AX_             extended macros
_AX_            helper macros not meant to be used directly
```

### Writing a low-level macro

Requirements:

1. print a _checking whether_ message
1. do the actual check
1. cache the result of the check

```
AC_DEFUN(MACRO-NAME,
[AC_CACHE_CHECK(
WHETHER-MESSAGER,
CACHE-VARIABLE,                    #should match *_cv_*
CODE-TO-SET-CACHE-VALUE)           #should contain the check, skipped when cache is used
CODE-USING-CACHE-VARIABLE])        #always executed, use AC_SUBST/AC_DEFINE
```

### aclocal.m4

1. `autoconf` knows only macros it provides: `m4_, AS_, AH_, AC_, AT_`, nothing
else(even `AM_` by automake)
1. `autoconf` reads _aclocal.m4_(constructed by _aclocal_) in addition to _config.ac_

`aclocal` searchs macros in

1.  directories specified by `-I`
1.  system-wide directory(`/usr/share/aclocal`)
1.  automake's macro directory

### libtool libraries

### Versioning libtool library:`-version-info`

1. CURRENT:  latest interface implemented
1. REVISION: implementation number of CURRENT
1. AGE:      (interface implemented times)-1

States                 | info           |
:---------------------:|:---------------|
old version            |CURRENT:REVISION:AGE
bug fixes              |CURRENT:REVISION+1:AGE
augument interface     |CURRENT+1:0:AGE+1
broken old interface   |CURRENT+1:0:0
