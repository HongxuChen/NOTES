## Chapter 1: Getting Started

### The startup files
* `zshenv`
* `zprofile`
* `zshrc`
* `zlogin`

```zsh
unset RCS # disables loading of files other than zshenv
unset GLOBAL_RCS # disables loading of files under /etc/
```

### prompt
`zshmisc` for manual, `shell state`
```zsh
setopt PROMPT_SUBST
print -l $fpath
$PS1
$PS2
$PS3
$PS4
$PROMPT
$RPROMPT
```

## Chapter 2: Alias and History

### Hashes
```zsh
hash -d gosrc=$HOME/gocode/src
```

### Brace expansion
```zsh
# Cartesian product
foo=(A B C)
bar=(1 2 3)
echo $^foo-$^bar
# A-1 A-2 A-3 B-1 B-2 B-3 C-1 C-2 C-3
```

### History expansion
`Word Designators` in `zshexpn`
```zsh
set histchars='@^#'
```

Chapter 3: Advanced Editing
`zshzle`

```zsh
bindkey
bindkey -L
bindkey -lL
esc + u
ctrl + y
esc + y
ctrl + t
esc + t
$WORDCHARS
read/read -k # read keystroke
esc + x # where-is mode mode
```

### Special variables
* `CURSOR` : This is the current position of the cursor on the command line.
* `BUFFER`: This contains the current editing buffer and can span multiple lines. 
* `LBUFFER`/`RBUFFER`: These are the contents to the left and right of the current
• `PREBUFFER`: This contains the buffer already read when editing a
• `WIDGET`: This gives the name of the widget currently in use by the editor.

### Multiline editing
```
bindkey '^Q' push-line-or-edit
```

## Chapter 4: Globbing

```zsh
echo *.??
echo main.?*
echo [ML]*
echo [1-5M]*.* # any filename starting with any number from 1 to 5 or an uppercase M
[.]* # won't work
echo [[:alpha:]]* # `Glob Operators`
echo *.[^o]
setopt csh_null_glob
setopt extended_glob
ls -l ***/*.md # follow symbolic links
ls -l */**/*.md # exclude curdir
echo [[:upper:]]*.(md|txt)
echo log_<10->.txt
echo log_<10-20>.txt
setopt numeric_glob_sort # ???
echo b^*.o
echo b^*.o
echo b*~*.o # tilde operator `~` defines a pattern that consists of part1 matches and part2 not
```

### Qualifiers
* Glob qualifiers: file type
* Timestamp qualifiers: c/m/a timestamp
* File size qualifiers: file size

### The zmv function
```zsh
autoload zmv
alias mmv='noglob zmv -W'
mmv *.c.orig orig/*.c
```

## Chapter 5: Completion
```zsh
echo `which print`<Tab>
echo =print
```

### Getting assertive with zstyle
```zsh
# :completion:function:completer:command:argument:tag

# message hints
zstyle ':completion:*:descriptions' format '%B%d%b'
zstyle ':completion:*:messages' format %d
zstyle ':completion:*:warnings' format 'No matches for: %d'

# ignore curdir
zstyle ':completion:*:cd:*' ignore-parents parent pwd

zstyle ':completion:*' squeeze-slashes true
```
