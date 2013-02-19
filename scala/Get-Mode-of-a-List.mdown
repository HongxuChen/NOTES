How to get the mode of a list?For instance:`val list = List(1, 3, 4, 4, 2);` should return 4

- GroupBy

```scala
list.groupBy(identity).mapValues(_.size).maxBy(_._2)._1
//or
list.groupBy(identity).maxBy(_._2.size)._1
```
`Map(2 -> 1, 4 -> 2, 1 -> 2, 3 -> 1)` is firstly generated for `list.groupBy(identity).mapValues(_.size)`; then it is sorted by the value of the Map using `.maxBy(_._2)`,with the result of `(4,2)`;`._1` get the first element(`4`) of the tuple

- count the frequency

```scala
list.maxBy(x => list.count(_ == x)) //inefficient
```

- update during the iteration

```scala
list.foldLeft(Map.empty[Int, Int].withDefaultValue(0)) {
  case (m, v) => m.updated(v, m(v) + 1)
}.maxBy(_._2)._1
```

- keep track of the maximum

```scala
list.foldLeft(
  Map.empty[Int, Int].withDefaultValue(0), -1 -> Double.NegativeInfinity
) {
  case ((m, (maxV, maxCount)), v) =>
    val count = m(v) + 1
    if (count > maxCount) (m.updated(v, count), v -> count)
    else (m.updated(v, count), maxV -> maxCount)
}._2._1
```

- [TODO]

```scala
list.distinct.foldLeft((0,0))((a, b) => {
     val cnt = x.count(_ == b);
   if (cnt > a._1) (cnt, b) else a
 })._2
```
