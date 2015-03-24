* open

```bash
cat ~/.zshrc |open -f -a /Applications/Microsoft\ Office\ 2011/Microsoft\ Word.app/Contents/MacOS/Microsoft\ Word
```

* PB

```bash
cat foo | sort | pbcopy
pbpaste | more
pbpaste | sort | pbcopy
pbpaste | sort | pbcopy
pbpaste | sed -e 's/foo/bar/g' | pbcopy
```

* spotlight

```bash
mdimport (force reindex, etc)
mfind Rails
mdfind -onlyin ~/Desktop Rails
mdfind "kMDItemContentType == 'com.microsoft.word.doc'"
mdfind "kind:pdf date:this week"
```
