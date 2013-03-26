In scala, the tuple is a container.

```scala
val tuple = ("nonoob", "leftcopy.chx@gmail.com", "blahblah...")
println(tuple._1)
```
We can implement this feature in Java.

```java
public class Tuple<A> {
     
    public static <A> Tuple mk(A ... args){
        return new Tuple(args);
    }
     
    private A[] items;
     
    private Tuple(A[] items) {
        this.items = items;
    }
         
    public A _(int index){
        if(index < 0 || items == null || index > items.length-1){
            return null;
        }
        return items[index];
    }
     
    public static void main(String[] args) {
        Tuple<String> t = Tuple.mk("nonoob", "leftcopy.chx@gmail.com", "blahblah...");
        System.out.println(t._(0));
    }
}
```
