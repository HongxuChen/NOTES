```scala
def callByName[T](block: => T) = {
    for( i<-0 until 3){
        println(block)
    }
}
def callByValue[T](block: T) = {
    for( i<-0 until 3){
        println(block)
    }
}
var a = 1;
def sum = {
    a = a + 1
    a
}
```
`Block` would be computed only once when called by `callByValue`, while it would be computed each time by `callByName`.

```scala
scala> callByValue(sum)
2
2
2
scala> callByName(sum)
3
4
5
``` 
