See http://blog.interlinked.org/tutorials/emacs.html


```
C-x C-w    #write file,prompt for name

C-d        #delete next char
M-x replace-string     #global string replacement
M-%        #query string replacement
M-d        #delete next word
C-w        #cut region
M-w        #copy region

C-M-\      #indent region(mode dependent)
C-M-q      #insert sexp(mode dependent)
C-x TAB    #indent region rigidly arg columns
C-o        #insert newline after point
C-M-o      #move rest of line vertically down
C-x C-o    #delete blank lines around point
M-^        #join line with previous
M-\        #delete all whitespace around point
M-SPC      #put ONE space at point
M-a 	   #backward-sentence
M-e 	   #forward-sentence

ESC ESC ESC
C-u #

C-r        #reversely search incrementally
C-x C-x    #swap mark and cursor
C-M-v      #scroll other window down
C-x ^      #grow window vertically

###replacing
SPC/y      #replace this, go to next
,          #replace this
DEL/n      #skip to next without replacing
!          #replace all matched
^          #back to previous
ESC        #exit query-replace
C-r        #enter recursive edit(C-M-c to exit)
C-w        #delete match and enter recursive edit
C-l 	   #re-center

M-u        #uppercase word
M-l        #lowercase word
M-c        #capitalize word
C-x C-u    #uppercase region
C-x C-l    #lowercase region

###searching
C-M-s      #regex search
C-M-r      #reverse regex search
M-p        #select previous search string
M-n        #select next later search string
Esc C-s    #isearch-forward-regexp
Esc C-r    #isearch-backward-regexp
n/a        #replace-string
M-%        #query-replace
```

```
C-x u (C-_)  #advertised-undo
M-Delete     #backward-kill-word
M-k 	     #kill-sentence
C-x Delete   #backward-kill-sentence
M-y 	     #遍历剪切环，必须跟 C-y
C-u, C-u N   #universal-argument，在命令前加上次数前缀
```

```
###window configurations
enlarge-window	【Ctrl+x ^】
shrink-window	◇
enlarge-window-horizontally	【Ctrl+x }】
shrink-window-horizontally	【Ctrl+x {】
shrink-window-if-larger-than-buffer	【Ctrl+x -】
balance-windows	【Ctrl+x +】
```
