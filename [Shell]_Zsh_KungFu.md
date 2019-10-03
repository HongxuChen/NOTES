> adapted from [ZSH-examples](https://www.mankier.com/1/zsh-lovers#Examples-ZMV-Examples_(require_autoload_zmv))

```
# load zmv
autoload -U zmv
# always run `zmv` with `-n` option beforehand
```

```
# rename files in current directory to 6-leading-zero-numbered files with extensions ".mp4"
c=1 zmv '*' '${(l:6::0:)$((c++))}.mp4'
```
