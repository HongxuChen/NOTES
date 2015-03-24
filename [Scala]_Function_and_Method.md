``` scala
// v1:String="is this"
def v1: String = {
  val g = () => { return "is this" }
  g()                               
  "not this"
}
// v2:String="is this"
def v2: String = {         
  def g(): String = { return "not this" }
  g()
  "is this"
}
//cannot compile,complains "return outside method definition"
val v3: String = {         
  def g(): String = { return "error here" }
  g()
  "oops!"
}
```
