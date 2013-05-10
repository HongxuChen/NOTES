###References:

- [Using Autotools - GNOME dev center](http://developer.gnome.org/anjuta-build-tutorial/stable/create-autotools.html.en)
- [图解aclocal、autoconf、automake、autoheader、configure | 风雪之隅](http://www.laruence.com/2008/11/11/606.html)

###Autotools

- autoscan: scan portablity problems such as compiler,libraries and head files;generate a preliminary configure.ac
- aclocal

```
user input files   optional input     process          output files
================   ==============     =======          ============
 
                    acinclude.m4 - - - - -. 
                                          V  
                                      .-------,
configure.ac ------------------------>|aclocal|
                 {user macro files} ->|       |------> aclocal.m4
                                      `-------'

```
- autoconf

```
user input files   optional input   processes          output files
================   ==============   =========          ============
 
                   aclocal.m4 - - - - - -.
                                         V
                                     .--------,
configure.ac ----------------------->|autoconf|------> configure ----->autoconfig.h,Makefile 
```
- autoheader

```
user input files    optional input     process          output files
================    ==============     =======          ============
 
                    aclocal.m4 - - - - - - - .
                                             |  
                                             V  
                                     .----------,
configure.ac ----------------------->|autoheader|----> config.h.in
                                     `----------'

```
- automake

```
user input files   optional input   processes          output files
================   ==============   =========          ============
 
                                     .--------,
                                     |        | - - -> COPYING
                                     |        | - - -> INSTALL
                                     |        |------> install-sh
                                     |        |------> missing
                                     |automake|------> mkinstalldirs
configure.ac ----------------------->|        |
Makefile.am  ----------------------->|        |------> Makefile.in
                                     |        |------> stamp-h.in
                                 .---+        | - - -> config.guess
                                 |   |        | - - -> config.sub
                                 |   `------+-'
                                 |          | - - - -> config.guess
                                 |libtoolize| - - - -> config.sub
                                 |          |--------> ltmain.sh
                                 |          |--------> ltconfig
                                 `----------'
```
- autoreconf: a Perl script to auto run all scripts in the right order.
- ...

![Autoconf-automake-process](http://upload.wikimedia.org/wikipedia/commons/8/84/Autoconf-automake-process.svg)

An example taken frome [this page](http://www.ezloo.com/2008/04/gnu_autotools.html):


###Original directory structure

```bash
.
├── hello.c
├── include
│   └── print.h
├── lib
│   ├── Makefile.am                            ###
│   └── print.c
└── Makefile.am                                ###
#2 directories, 5 files
```
- hello.c

```c
include "include/print.h"
int main(void)
{
       print("Hello, Aillo\n");
       return 0;
} 
```
- include/print.h

```c
void print ( char *s );
```
- lib/print.c

```c
#include "../include/print.h"
#include<stdio.h>
void print(char *string)
{
       printf("%s",string);
}
```
- Makefile.am

```bash
SUBDIRS = lib
AUTOMAKE_OPTIONS = foreign
bin_PROGRAMS = hello
hello_SOURCES = hello.c
hello_LDADD = ./lib/libprint.a
```
- /lib/Makefile.am

```bash
noinst_LIBRARIES = libprint.a
libprint_a_SOURCES = print.c ../include/print.h
```

###After `autoscan`

```bash
.
├── autoscan.log                               #log file
├── configure.scan                             ###
├── hello.c
├── include
│   └── print.h
├── lib
│   ├── Makefile.am
│   └── print.c
└── Makefile.am
#2 directories, 7 files
```

###Modify `configure.scan` and rename it to `configure.ac`
Notes:old version use `configure.in`

###After `aclocal`

```bash
.
├── aclocal.m4                                ###
├── autoscan.log                              
├── autom4te.cache                            #autoconf internal files.neglect
│   ├── output.0                              # 
│   ├── requests                              #
│   └── traces.0                              #
├── configure.ac
├── hello.c
├── include
│   └── print.h
├── lib
│   ├── Makefile.am
│   └── print.c
└── Makefile.am
#3 directories, 11 files
```

###After `autoconf`

```bash
.
├── aclocal.m4
├── autom4te.cache
│   ├── output.0
│   ├── output.1                              #
│   ├── requests
│   ├── traces.0
│   └── traces.1                              #
├── autoscan.log                               
├── configure                                 ###
├── configure.ac
├── hello.c
├── include
│   └── print.h
├── lib
│   ├── Makefile.am
│   └── print.c
└── Makefile.am
#3 directories, 14 files
```

###After `autoheader`

```bash
.
├── aclocal.m4
├── autom4te.cache
│   ├── output.0
│   ├── output.1
│   ├── requests
│   ├── traces.0
│   └── traces.1
├── autoscan.log                              
├── config.h.in                              ###
├── configure
├── configure.ac
├── hello.c
├── include
│   └── print.h
├── lib
│   ├── Makefile.am
│   └── print.c
└── Makefile.am
#3 directories, 15 files
```

###After `automake --add-missing`

```bash
.
├── aclocal.m4
├── autom4te.cache
│   ├── output.0
│   ├── output.1
│   ├── requests
│   ├── traces.0
│   └── traces.1
├── autoscan.log                              
├── config.h.in
├── configure
├── configure.ac
├── depcomp -> /usr/share/automake-1.11/depcomp    ###
├── hello.c
├── include
│   └── print.h
├── install-sh -> /usr/share/automake-1.11/install-sh   ###
├── lib
│   ├── Makefile.am
│   ├── Makefile.in                                     ###
│   └── print.c
├── Makefile.am
├── Makefile.in                                         ###
└── missing -> /usr/share/automake-1.11/missing         ###
#3 directories, 20 files
```

###After `./configure`

```bash
.
├── aclocal.m4
├── autom4te.cache
│   ├── output.0
│   ├── output.1
│   ├── requests
│   ├── traces.0
│   └── traces.1
├── autoscan.log                              
├── config.h
├── config.h.in
├── config.log                                         ###
├── config.status                                      ###
├── configure
├── configure.ac
├── depcomp -> /usr/share/automake-1.11/depcomp
├── hello.c
├── include
│   └── print.h
├── install-sh -> /usr/share/automake-1.11/install-sh
├── lib
│   ├── Makefile                                      ###
│   ├── Makefile.am
│   ├── Makefile.in
│   └── print.c
├── Makefile                                          ###
├── Makefile.am
├── Makefile.in
├── missing -> /usr/share/automake-1.11/missing
└── stamp-h1                                          #timestap for config.h
#3 directories, 26 files
```

###After `make`

```bash
.
├── aclocal.m4
├── autom4te.cache
│   ├── output.0
│   ├── output.1
│   ├── requests
│   ├── traces.0
│   └── traces.1
├── autoscan.log                              
├── config.h
├── config.h.in
├── config.log
├── config.status
├── configure
├── configure.ac
├── depcomp -> /usr/share/automake-1.11/depcomp
├── hello                                             ###
├── hello.c
├── hello.o                                           ###
├── include
│   └── print.h
├── install-sh -> /usr/share/automake-1.11/install-sh
├── lib
│   ├── libprint.a                                    ###
│   ├── Makefile
│   ├── Makefile.am
│   ├── Makefile.in
│   ├── print.c
│   └── print.o                                       ###
├── Makefile
├── Makefile.am
├── Makefile.in
├── missing -> /usr/share/automake-1.11/missing
└── stamp-h1
#3 directories, 30 files
```