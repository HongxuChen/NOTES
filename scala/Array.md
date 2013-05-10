```scala
object Main extends App {
  class A {
    var a=0
  }
  val b = Array.fill(2)(new A)
  b(1).a = 9
  println(b(0).a) //prints 0
  println(b(1).a) //prints 9

  val a = new A
  val c = Array.fill(2)(a)
  c(1).a = 9
  println(c(0).a) //prints 9
  println(c(1).a) //prints 9
}
```