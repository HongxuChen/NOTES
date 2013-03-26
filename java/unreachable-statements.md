###Java Language Specification 14.21.[Unreachable Statements](http://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.21)

1. It is a *compile-time error* if a statement cannot be executed because it is unreachable.
1. Except for the special treatment of *while*, *do*, and *for* statements(without *if*!) whose condition expression has the constant value *true*, the values of expressions are not taken into account in the flow analysis.
1. The rationale for differing treatment with *if* is to allow programmers to define "flag variables"  for *conditional compilation* purposes,e.g.

  ```java
  static final boolean DEBUG = false;
  if (DEBUG) { x=3; }
  ```

###Examples:

```java
//Segment A (Compilation Error)
public void javapapers() {
    System.out.println("java");
    return;
    System.out.println("papers");//unreachable
}

//Segment B (Compilation Succeed)
public void javapapers() {
    System.out.println("java");
    if(true) {
        return;
    }
    System.out.println("papers");//reachable
}

//Segment C (Compilation Error)
public void javapapers() {
    System.out.println("java");
    while(true) {
        return;
    }
    System.out.println("papers");//unreachable
}

//Segment D (Compilation Succeed)
public void javapapers(){
    int n = 5;
    while(n>7)System.out.println("javapapers");//reachable
}

//Segment E (Compilation Succeed)
public void javapapers(){
    if(false)System.out.println("javapapers");//reachable
}
```
