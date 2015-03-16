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

1. `git pull` == `git fetch;git merge`

1. restore from `git rm/add`
   * `git rm <file>` && not committed: 
```
git reset HEAD <file>     #unstage
git checkout -- <file>    #discard changes
```
   * `git add <file>` && not committed:`git reset HEAD <file>` would make `<file>` _untracked_ .
   * `git commit`: `git reset HEAD^ <file>` would make added(before commit) _untracked_ and removed(before commit) _unstaged_ .

1. `git rebase -i HEAD~<num>`, `<num>` specifies the number of commits to be merged(interative); there would be `<num>-1` lines for you to merge(squash,fixup,etc) and last commit is at the bottom.
1. view commit differences with `<other>` branch: 
```bash
git log <other>..                        #current branch contains && <other> not
git log ..<other>                        #<other> contains && current not
```
1. git diff
```bash
git diff                           #unstaged update
git diff --cached/--staged         #diff with last commit
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
git log --pretty=format:"%h - %an, %ar : %s"     #pretty format(search placeholders in manpage); another option can be *--pretty=oneline*
git log --since=2.weeks     #*--until*
```

1. revert operations
```bash
git commit -m 'initial commit'
git add forgotten_file
git commit --amend                 #only one commit
```

1. remote repository(`git remote`)
```bash
git remote -v
git fetch <name>
git remote show <name>
git remote rename <old> <new>        #remote branch also changed
```
