```bash
scala> def test[A](a: List[A])(f: A => A) = a.map(f)
test: [A](a: List[A])(f: (A) => A)List[A]

scala> test(List(1))(_+1)
res1: List[Int] = List(2)
```

##type erasure helps unexpected inheritance:

```scala
trait Foo
trait Dummy[A]
trait Bar extends Dummy[Bar]{ this: Foo => }
trait NoBar extends Dummy[NoBar]{ this: Foo => }
new Foo with Bar with NoBar {}
```
Would emits[TODO:why](http://stackoverflow.com/questions/14010461/disallow-mix-of-specific-traits):

```bash
illegal inheritance; anonymous class $anon inherits different
type instances of trait Dummy: Dummy[Bar] and Dummy[NoBar]
```
