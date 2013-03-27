1. Meet the Dot Command
    ```
    line one
        line two
            line three
                line four
    ```

1. Don't Repeat Yourself
    ```javascript
    var foo = 1;
    var bar = 'a';
    var foobar = foo + bar;
    ```

1. one back, three forward
    ```javascript
    var foo "method(" + argument1 + "," + argument2 + ")";
    ```

1. act,repeat,reverse
`@:`,`:substitude`
    ```
    +----------------------------+---------------+---------+--------+
    |Intent                      |Act            |Repeat   |Reverse |
    +----------------------------+---------------+---------+--------+
    |Make a change               |{edit}         |.        |u       |
    +----------------------------+---------------+---------+--------+
    |scan line for next char     |f{char}/t{char}|;        |,       |
    +----------------------------+---------------+---------+--------+
    |scan line for previous char |F{char}/T{char}|;        |,       |
    +----------------------------+---------------+---------+--------+
    |exec a sequence of changes  |qx{changes}q   |@x       |u       |
    +----------------------------+---------------+---------+--------+
    ```

1. Find and Replace by Hand  
   Make changes repeatable so `.` can be used

1. Meet the Dot Formula

1. Pause with Your Brush Off the Page  
Customed to normal mode

1. Chunk Your Undos  
Vim's undo granularity is not that small, a change could be anything that
modifies the text in the document. Insert mode <CR> doesn't trigger a new
change, but <Left>,<Right>,<Up>,<Down>.

1. Compose Repeatable Changes  
   Repeatable key-strokes: <kbd>dbx</kbd>,<kbd>bdw</kbd>,<kbd>daw</kbd>

1. Use Counts to Do Simple Arithmetic  
   <kbd>C-a</kbd>, <kbd>C-x</kbd> to increase/decrease

   ```css
   .blog, .new{background-image: url(/sprite.png);}
   .blog {background-position: 0px 0px}
   .news {background-position: 0px 0px}
   ```

1. Don't Count If You Can Repeat  
<kbd>dw.</kbd> is better than  <kbd>d2w</kbd>, or  <kbd>2dw</kbd> 

1. Combine and Conquer  
Operator+Motion=Action: <kbd>d</kbd> <kbd>c</kbd> <kbd>y</kbd> <kbd>g~</kbd>
   <kbd>gu</kbd> <kbd>gU</kbd> <kbd>></kbd> <kbd><</kbd> <kbd>=</kbd>
   <kbd>!</kbd>  
   NOTE: operator-pending mode

1. Make Corrections Instantly from Insert Mode  
<kbd>C-u</kbd> delete back to start of a line.

1. Get Back to Normal Mode  
Insert Normal Mode:<kbd>C-o</kbd> 

1. Paste from a Register Without Leaving Insert Mode  

    ```txt
    Practical Vim, by Drew Neil
    Read Drew Neil's Practical Vim
    ```
<kbd>C-r(register)</kbd> might has unwanted line breaks if `textwidth` or
`autoindent` are enabled, <kbd>C-r C-p(register)</kbd> is smarter.

1. Do back-of-the_envelope Calculations in Place  
<kbd>C-r=</kbd> 

    ```txt
    6 chairs, each costing $35, totals $210
    ```

1. Insert Unusual Characters by character Code  
<kbd>C-v{code}</kbd> <kbd>C-vu{code}</kbd> <kbd>C-k{char1}{char2}</kbd> <kbd>C-v{nondigit}</kbd> 

1. Insert Unusual Characters by Digraph  
    1. `:h digraphs-default`
    1. `:h digraphs-table`
    1. `:digraphs`
    
1. Overwrite Existing Text with Replace Mode  
`Virtual Replace Mode`, <kbd>gR</kbd>,<kbd>gr</kbd>, would treat tab as spaces;

1. Grok Visual Mode  
<kbd>V</kbd> linewise, <kbd>o</kbd> to other end of highlighted text.<kbd>gv</kbd> reset the last visual selection
in normal mode.

    ```txt
    select from here to here.
    ```
    
1. Define a Visual Selection  

1. Repleat Line-Wise Visual Commands  
    ```python
    def fib(n):
        a, b = 0, 1
        while a < n
            print a
            a, b = b, a + b
    fib(42)
    ```

1. Prefer Operators to Visual Commands Where Possible  
    ```html
    <a href="#">ONE</a>
    <a href="#">TWO</a>
    <a href="#">THREE</a>
    ```
NOTE:`gUit` and `vitU` with repeat behaviors differently.

1. Edit Tabular Data with Visual-Block Mode
    ```txt
    Chapter      |    Page
    ----------------------
    Normal mode  |      15
    Insert mode  |      31
    Visual mode  |      44
    ```
NOTE:`Vr-` can be useful

1. Change Columns of Text  
    ```css
    li.one     a{ background.image: url('components/sprite.png);}
    li.two     a{ background.image: url('components/sprite.png);}
    li.three   a{ background.image: url('components/sprite.png);}
    ```

1. Append After a Ragged Visual Block  
```javascript
var foo = 1;
var bar = 'a';
var foobar = foo + bar;
```
