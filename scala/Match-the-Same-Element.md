for `val l= List(1,1,2,1,)` Scala does not support the use of:  

```scala
l match{
  case x::x::y::x::xs => println(l)
  case _ => println("not match")
  }
```
The remedies are like:  

- Specify a `same` function:

```scala
def same[A](xs: A*)=xs forall(xs.head==)
l match{
  case x1::x2::x3::x4::xs if same(x1,x2,x4) => println(l)
  case _ => println("not match")
}
```
- Specify the value(`x`) of the same and use \`x\` in the match:

```scala
val x = list.head 
list match {
  case `x`::`x`::`x`::`x`::xs => ....
}
```
- Also `Option` can be used here

```scala
val x = list.head
(l.headOption,l) match{
  case (Some(`x`),`x`::`x`::x1::`x`::xs) => println(l)
  case (None,_) => println("no match")//default,no need for *case _*
}
```
And a variant of this is:

```scala
val x = list.head
l.headOption map (x => l match { 
   case `x`::`x`::x1::`x`::xs => println(l)
   case _ => println("no match")
 }) getOrElse {
   // do what you'd have done for an *empty* list...
 }
```
reference:[Use same variable multiple times within one pattern](http://stackoverflow.com/questions/13963507/use-same-variable-multiple-times-within-one-pattern)
