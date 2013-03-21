```
BUFFER
save as...  c-x c-w
Save all     C-x s
Make read only   C-x C-q
Write    C-x C-w

WINDOW
scroll other    ESC C-v
find file in new window C-x 4 f

COPY-PASTE
Begin selection C-SPACE
Select paragraph    ESC h
Copy     ESC w
Kill (cut)  C-w
yank (paste)    C-y
Paste former copies ESC y
kill line   C-k
kill rectangle <br /> defined by selection  C-x r k
yank rectangle  C-x r y

REPEAT
repeat next command ESC (number)
repeat four times next command  C-u
last complex commands   C-x ESC ESC
Edition
transpose character C-t
transpose word  M-t
complete text   M-/
undo last   C-/

SEARCH
normal search   C-s RET
search word under cursor    C-s C-w RET
Query-replace    ESC %
Regular expression search    ESC C-s RET
Regular expression <br /> query-replace  query-replace-regexp
grep    M-x grep RET

BOOKMARKS
Create  C-x r m
Go to   C-x r b
External commands
shell command   ESC !!!
shell command on selection  ESC |
shell mode  ESC x shell
terminate   C-c C-c
last    ESC p

MACROS
begin def   C-x (
end def C-x )
run C-x e
append  C-u C-x (
name    ESC x name-last-kbd-macro
save    C-x C-f filename RET <br /> ESC x insert-kbd-macro RET <br /> macroname RETURN <br /> C-x C-s
load    ESC x load-file

PROGRAMMING
line-feed-and-indent    C-j
indent-region   ESC C-\
join lines  ESC ^
go to 1st col   C-a
go to last col  C-e
go to first char    ESC m
c-begining-of-statement ESC a
beginning-of-defun  ESC C-a
c-fill-paragraph    ESC q
add comment ESC ;
compile ESC x compile RET
nect-error  C-x `

TAGS
find tag    M-.
find next   C-u M-.
back    M-*
previous    C-u - M-.
find-tag-other-window   C-x 4 . tag RET
find-tag-other-frame    C-x 5 . tag RET
find with regex C-M-. pattern RET
next    C-u C-M-
complete tag    ESC TAB

HELP
apropos apropos
super-apropos   super-apropos
```
