scala> List("hello","world",2)(0)
res25: Any = hello

scala> val animals = Set("lions","tigers","bears");animals & Set("tigers","duck")
res34: scala.collection.immutable.Set[java.lang.String] = Set(tigers)

scala> import scala.collection.mutable.Hash
scala> map += 4->"fourth";map += 5->"five";map += 4->"4th"
res37: map.type = Map(5 -> five, 4 -> 4th)
map.foreach(ani=>println("I love " + ani._1))

scala> val newList = List("hello","everyone","good","morning")
scala> newList.sort((s,t)=>s.charAt(2).toLowerCase < t.charAt(2).toLowerCase)
//newList.head,newList.tail,newlist.last,newList.init
//count,map,filter,forall,exists

scala> var sum = 60; for(i <- 0 until list.length){sum+=list(i);}
scala> val sum = (60 /: list){(sum,i)=>sum+i}
scala> val sum=list.foldLeft(60)((sum,value)=>sum+value)
scala> newList.foldLeft("")((left,right)=>left+right)

scala> val movies = 
     | <movies>
     | <movie genre="action">Pirates of the Caribbean></movie>
     | <movie genre="fairytale">Edward Scissorhands</movie>
     | </movies>
movies: scala.xml.Elem = 
<movies>
<movie genre="action">Pirates of the Caribbean&gt;</movie>
<movie genre="fairytale">Edward Scissorhands</movie>
</movies>
scala> movies.text
res18: String = 
"
Pirates of the Caribbean>
Edward Scissorhands
"
scala> val moviesNodes = movies \ "movie"
moviesNodes: scala.xml.NodeSeq = NodeSeq(<movie genre="action">Pirates of the Caribbean&gt;</movie>, <movie genre="fairytale">Edward Scissorhands</movie>)
scala> moviesNodes(0)
res20: scala.xml.Node = <movie genre="action">Pirates of the Caribbean&gt;</movie>

