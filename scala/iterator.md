All Scala `Tuples` extend `Product`. You can use its `productIterator` to iterate over tuple items:

```scala
(10,"test",6.8).productIterator.foreach(println)
```

`foreach` is used as traverse and not iterating, so remove/add operation may lead erros.

```scala
import scala.collection.mutable
val a = mutable.Set(1,2,3,4,5)
a.foreach(x => { println(x); a.remove(x) }
```
