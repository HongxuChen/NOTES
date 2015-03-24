Useful pages:  
- [Git Wiki](https://git.wiki.kernel.org/index.php/Main_Page)
- [Git Magic](http://www-cs-students.stanford.edu/~blynn/gitmagic/book.pdf)
- [Got Git](https://github.com/gotgit)
- [Git Community Book](http://alx.github.com/gitbook/)

1. git status:  
   - untracked  => raw files without git features
   - staged  =>  related with `--cached`
   - committed and not modified => related with `HEAD^`

1. remove cached files
  ```bash
  git add .
  git ls-files | xargs git rm --cached
  ```

1. pattern matching
Git has its own pattern matching.
  ```bash
  git ls-files log/\*.log              #list files ended with .log in log folder recursively
  git ls-files log/*.log               #not recursively
  ```
1. git log
  ```bash
  git log -p -2               #content updates of 2 latest commit
  git log -stat -1            # line updates of the last commit
  git log --since=2.weeks     #*--until*
  ```
