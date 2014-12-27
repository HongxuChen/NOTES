###shopt and set
`shopt` is a substitute for `set`(which is inherited from other Bourne-style shells like `ksh`).

```bash
shopt -p               #view option on/off settings,similiar with *set -o*
shopt –o –s noclobber  #set -o noclobber
shopt -o -u physical   #set +o physical
```

###extglob
In addition to the traditional [glob](http://en.wikipedia.org/wiki/Glob_(programming\)) (supported by all _Bourne-style shells_), Bash (and Korn Shell) offers extended globs, which have the expressive power of regex. Korn shell enables these by default.

```bash
shopt -s extglob #set
shopt -u extglob #unset
```
```bash
#pattern-list is separated with '|'
?(pattern-list)         <= 1
*(pattern-list)         >= 0
+(pattern-list)         >= 1
@(pattern-list)         or
!(pattern-list)         !=

rm -rf !(*.ll)
rm -rf @(*.s|*.ll)          
```

References:
- <http://wiki.bash-hackers.org/internals/shell_options>

### test
`test` and `[`(acompany with `]`) are tools that does test work.
It returns 0(true) or 1(false)! Just ignore the oddity and take a look at the
examples below.

```bash
test 3 -gt 4 && echo True || echo false   #false
[ "abc" != "def" ];echo $?                #0
test -d "$HOME" ;echo $?                  #0
[ ! -f /etc/hosts ] && echo "Found" || echo "Not found"  #typical usage, or *test ! -f /etc/hosts*
```

### pattern match

Use `man bash` for help, `parameter` is the whole string(s) to be manipulate, delete those matched.

```bash
${parameter#word}      #matches beginning
${parameter##word}     #matches beginning
${parameter%word}      #matches tail
${parameter%%word}     #matches tail
```
```bash
FILE="example.tar.gz"
echo "${FILE%%.*}"     #example
echo "${FILE%.*}"      #example.tar
echo "${FILE#*.}"      #tar.gz
echo "${FILE##*.}"  #gz
```

- change prefix of several file names: 

```bash
$ ls
old old.c old.tar.gz
$ for file in old*;do mv $file new${file#old};done;ls
new new.c new.tar.gz
```
