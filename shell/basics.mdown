- `read`:No need to use `"` or `'` to escape blank when `read` variables(`\` can be used).

```bash
$ read var
"Hello\ \
>World \
>! '\n
$ echo -e $var
"Hello World ! 'n
```

- compound statement

```bash
if condition then statement elif condition; then statement else statement fi #if
while/until condition do statenment done #while/until
#case
case var in
	passtern [| pattern]... ) statement1;;
	passtern [| pattern]... ) statement2;;
	...
esac
```
- `eval` to evaluate

```bash
foo=10
x=foo #echo $y --> foo
y='$'$x
echo $y # --> $foo
eval y='$'$x
echo $y # --> 10
```

- shift
- trap

##Environment variables:
```bash
TERM                # terminal types
LANG
EDITOR
```
##references:

1. <http://share.solrex.org/cheatsheet/slc/Solrex.Linux.Cheatsheet.pdf>
