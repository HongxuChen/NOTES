Use to run hello if the executable is dynamically linked.

```bash
export LD_LIBRARY_PATH=$LD_LIBRARY:$PWD/test/lib
./test/bin/hello
```

Check whether or not executable is dyanmically linked with `ldd`

When `libtool` is used, the generated executable might be a wrapper shell script
so that `gdb` doesn't work. But we can use command below:

```bash
libtool --mode=executable gdb -q src/hello
```

Before using `gettext` to implement L10n, we should:

```bash
gettextsize --copy --no-changelog
cp /usr/share/gettext/gettext.h src
```
