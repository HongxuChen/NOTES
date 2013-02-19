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
