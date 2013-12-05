`test` and `[`(acompany with `]`) are tools that does test work.

It returns 0(true) or 1(false)! Just ignore the oddity and take a look at the
examples below.

```bash
test 3 -gt 4 && echo True || echo false   #false
[ "abc" != "def" ];echo $?                #0
test -d "$HOME" ;echo $?                  #0
[ ! -f /etc/hosts ] && echo "Found" || echo "Not found"  #typical usage, or *test ! -f /etc/hosts*
```
