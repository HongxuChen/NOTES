```Python
def ExFun(n):
  def InsFun():return n
return InsFun
myFun1=ExFun(2)
myFun1()
myFun2=ExFun(2.4)
myFun2()
```

```Scala
def ExFun(n:Int):Int={
  def InsFun()=n+1
  return InsFun
}
val myFun1=ExFun(2)
```