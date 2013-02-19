Delete all the lines that contains some string patterns(`hello` for instance):

```bash
sed /hello/d [input] > [output]
cat file | grep -v hello > result  #not an efficient way, using pipe
:g/hello/d  #in VIM;
:g/^\(.*\)$\n\1$/d #in VIM, delete duplicated lines
```
