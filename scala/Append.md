```scala
val l1 = List(1,2,3,4,5)
val l2 = List(6,7,8,9,10)
l1 ++ l2
(l1 :\ l2) ((a,b)=>a::b) ##fold right