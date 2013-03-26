It is just like REPL in Python,`tab` for completion is also supported.

```bash
:cp <path>                 add a jar or directory to the classpath
:help [command]            print this summary or command-specific help
:history [num]             show the history (optional num is commands to show)
:h? <string>               search the history
:imports [name name ...]   show import history, identifying sources of names
:implicits [-v]            show the implicits in scope
:javap <path|class>        disassemble a file or class name
:keybindings               show how ctrl-[A-Z] and other keys are bound
:load <path>               load and interpret a Scala file
:paste                     enter paste mode: all input up to ctrl-D compiled together
:power                     enable power user mode
:quit                      exit the interpreter
:replay                    reset execution and replay all previous commands
:sh <command line>         run a shell command (result is implicitly => List[String])
:silent                    disable/enable automatic printing of results
:type <expr>               display the type of an expression without evaluating it
```
If we use the `:power`, we'll get the following statements():

```bash
** Power User mode enabled - BEEP BOOP SPIZ **
** :phase has been set to 'typer'.          **
** scala.tools.nsc._ has been imported      **
** global._ and definitions._ also imported **
** Try  :help,  vals.<tab>,  power.<tab>    **
```
Then 3 additional command is supported:  

```bash
:dump displays a view of the interpreter's internal state
:phase <phase> set the implicit phase for power commands
:wrap <method> * name of method to wrap around each repl line
```
`wrap` is marked with `*` so it has more detailed help(`:he wrapper`). It is more like a Python `decorator`. You can define a custom method to wrap around each REPL line.

```bash
#paste mode is not useful for this wrap
scala> def timed[T](body: => T): T = {
     |   val start = System.nanoTime
     |   try body
     |   finally println((System.nanoTime - start) + " nanos elapsed.")
     | }
timed: [T](body: => T)T
scala> :wrap timed
Set wrapper to 'timed'
scala> val l = List(1,2,3)
334949 nanos elapsed.
l: List[Int] = List(1, 2, 3)
```
Run scala scripts directly in a shell script:

```bash
#!/bin/sh
exec scala "$0" "$@"
!#
object HelloWorld {
  def main(args: Array[String]): Unit = {
        println("Hello world "+args(0))
    }
}
HelloWorld.main(args)

```
`/usr/bin/env scala` gives a lightweight way to run script using scala([TODO:why](http://stackoverflow.com/questions/14030684/two-ways-of-starting-a-scala-script-which-is-preferable)).

```bash
#!/usr/bin/env scala
!#
println("hello world")
```
In Windows, there's a similiar way.

```bat
::#!
@echo off
call scala %0 %*
goto :eof
::!#
println("Hello world "+ args(0) +"!")
```
Or we can use `scala test.scala [args_list]` to run the script,like:

```scala
//test.scala
println("Hello world "+argv(0))
```
We can also load scala script using `:load script.scala`,which is like `execfile("script.py")` in Python(`python -i script.py` or `#!/usr/bin/python -i` is also available in python),however we __cannot__ load any other args.
