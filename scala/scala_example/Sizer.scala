import scala.io._
import scala.actors._
import Actor._

object PageLoader extends Application {
    def getPageSize(url: String) = Source.fromURL(url).mkString.length
}

val urls = List("http://www.douban.com", "http://www.bing.com", "http://www.github.com", "http://www.renren.com")
timeMethod(getPageSizeSequentially)
timeMethod(getPageSizeConcurrently)

def timeMethod(method:()=>Unit)={
    var start = System.nanoTime
        method()
        val end = System.nanoTime
        println("method took "+(end-start) + " nano seconds")
}

def getPageSizeSequentially()=
for(url<-urls){
    println(url+" size:"+PageLoader.getPageSize(url))
}

def getPageSizeConcurrently(){
    val caller = self
        for(url<-urls){
                actor{
                    caller ! (url,PageLoader.getPageSize(url))
                }
        }
    for(i<-1 to urls.size){
        receive{
            case(url,size)=>
                println(url + " size:"+size)
        }
    }
}
