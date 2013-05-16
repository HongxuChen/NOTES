###finally
 ___never___ return from `finally`  

```scala
//x == true;*Boolean* is optional here
def x:Boolean = try{
  true
} finally false
//y == false,the same as Java;*Boolean* is mandatory
def y:Boolean = try{
  return true
} finally {
  return false
}
//
def z : Boolean = {
  val foo = try { true } finally { return false }
  true
}
```
