```scala

trait Foo {
  def bar = { println("in_foo") }
}

class Baz extends Foo{
  override def bar = { println("in_bar")}
}
```
Using [JD-GUI](http://java.decompiler.free.fr/?q=jdgui) we can get the java form of the class files(`Baz`,`Foo` and `Foo$class`; <em>Predef.</em> should be _Predef$_)  

```java
public abstract class Foo$class{
  public static void bar(Foo $this)  {
    Predef$.MODULE$.println("in_foo");
  }
  public static void $init$(Foo $this)  {
  }
}

public abstract interface Foo extends ScalaObject
{
  public abstract void bar();
}

public class Baz implements Foo{
  public void bar(){
    Predef$.MODULE$.println("in_bar");
  }
  public Baz()  {
    Foo.class.$init$(this);
  }
}
```
