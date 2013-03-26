Sometimes the argument we get from stdin may be _null string_(not set),`test` the arg would lead to errors.For instance, an `[: =: unary operator expected` error would emit if we run _script.sh_ and do not pass any args.

```
#script.sh
option=$1
if [ $option = "arg" ]  #ERROR, use *[[ $option = "arg" ]]* instead!
then echo $option
fi
```
