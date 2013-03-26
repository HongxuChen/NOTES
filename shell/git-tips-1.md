Useful pages:  
- [Git Wiki](https://git.wiki.kernel.org/index.php/Main_Page)
- [Git Magic](http://www-cs-students.stanford.edu/~blynn/gitmagic/book.pdf)
- [Got Git](https://github.com/gotgit)
- [Git Community Book](http://alx.github.com/gitbook/)

Useful commands:`git status`,`gitk`,`git help`

1. git status:  
![file status lifecycle](http://blog.jobbole.com/wp-content/uploads/2012/08/20120201121432_845.png)
   - untracked  => raw files without git features
   - staged  =>  related with `--cached`
   - committed and not modified => related with `HEAD^`

1. remove cached files
```bash
git commit -m "commit info"
git ls-files | xargs git rm --cached
```

1. git does not add dirs, use `git add <dir>` to add files inside `dir`.

1. git add ([reference](http://stackoverflow.com/questions/572549/difference-of-git-add-a-and-git-add/572660#572660)) 
   * `git add -A`(new+modified+deleted)
   * `git add .`(new+modified)
   * `git add -u`(modified+deleted) 

1. `git pull` == `git fetch;git merge`

1. restore from `git rm/add`
   * `git rm <file>` && not committed: 
```
git reset HEAD <file>     #unstage
git checkout -- <file>    #discard changes
```
   * `git add <file>` && not committed:`git reset HEAD <file>` would make `<file>` _untracked_ .
   * `git commit`: `git reset HEAD^ <file>` would make added(before commit) _untracked_ and removed(before commit) _unstaged_ .

1. `git push -f` forces remote repo to be consistent with local([recovery](http://www.programblings.com/2008/06/07/the-illustrated-guide-to-recovering-lost-commits-with-git/)).

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

1. skip the `staged` procedure: `commit -a`(commit all _tracked_ files)

1.  add or delete `<file>`:
   - add `<file>` (untrack => stage)
```bash
add <file>;git add .
git add <file>            #file must exist
```
   - delete `<file>` (untrack => NULL)
```bash
rm <file>;git add -u
git rm <file>
```
   - delete `<file>` (stage => untrack)
```bash
git rm --cached <file>
```
Note: `<file>` that is `git add/rm/mv` is always _staged_ . `git mv <dir1> <dir2>` is the same as `git mv` all files in `<dir1>` to `<dir2>`

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