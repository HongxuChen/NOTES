##vundle

- installation:`$ git clone https://github.com/gmarik/vundle.git ~/.vim/bundle/vundle` or `$HOME/.vim/bundle/vundle` in Windows.

```
"for vundle
set rtp+=~/.vim/bundle/vundle/
 call vundle#rc()
"let Vundle manage Vundle, required!
Bundle 'gmarik/vundle'
Bundle 'taglist.vim'
Bundle 'mru.vim'
Bundle 'desert256.vim'
Bundle 'xml.vim'
Bundle 'The-NERD-tree'
Bundle 'matrix.vim'
Bundle 'The-NERD-Commenter'
Bundle 'Raimondi/delimitMate'       
```

reference:[gmarik/vundle-github](https://github.com/gmarik/vundle)

###vim-addons and vim-scripts

- powerful in debian based Linux distribution
- `/usr/share/doc/vim-scripts/README.Debian`
- `dpkg -L vim-scripts |grep README`

###taglist and ctags

- Install ctags,`sudo apt-get install exuberant-ctags`
- Install taglist, `Bundle 'taglist.vim'` and configure it

```bash
let Tlist_Ctags_Cmd = "/usr/bin/ctags"
let Tlist_WinWidth = 50
map <leader>t :TlistToggle<cr>
```

Keyboard command | Action
|:--------------:|:------|
Ctrl-]           |Jump to the tag underneath the cursor
:ts <tag> <RET>  |Search for a particular tag
:tn              |Go to the next definition for the last tag
:tp              |Go to the previous definition for the last tag
:ts              |List all of the definitions of the last tag
Ctrl-t           |Jump back up in the tag stack

reference:

- [Using ctags in Vim](http://amix.dk/blog/post/19329)
- [Ctags Tutorial](http://www.cs.washington.edu/education/courses/cse451/12sp/tutorials/tutorial_ctags.html)
