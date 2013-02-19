Using `case`:

```scala
val l = List((1,2,3), (2,3,4), (3,4,5))
val l.map((x,y,z)=>(x,z))
```

Without `case`:

```scala
val l: List[Tuple3[_, _, _]] = List((1,2,3), (2,3,4), (3,4,5))
l map (e => (e._1, e._3))
```
