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

    ```
    Practical Vim, by Drew Neil
    Read Drew Neil's Practical Vim
    ```
<kbd>C-r(register)</kbd> might has unwanted line breaks if `textwidth` or
`autoindent` are enabled, <kbd>C-r C-p(register)</kbd> is smarter.

1. Do back-of-the_envelope Calculations in Place  
<kbd>C-r=</kbd> 

    ```
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

    ```
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
    ```
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

1. Meet Vim's Command Line  
    ```
    +--------------------------------------------+----------------------------------------+
    |Command                                     |Effect                                  |
    +--------------------------------------------+----------------------------------------+
    |:[range]delete[x]                           |delete lines [into register x]          |
    +--------------------------------------------+----------------------------------------+
    |:[range]yank[x]                             |yank lines [into register x]            |
    +--------------------------------------------+----------------------------------------+
    |:[line]put[x]                               |put hte text from register x after the  |
    |                                            |line                                    |
    +--------------------------------------------+----------------------------------------+
    |:[range]copy{address}                       |copy lines to below the line specified  |
    |                                            |by {address}                            |
    +--------------------------------------------+----------------------------------------+
    |:[range]move{address}                       |move lines to below the line specified  |
    |                                            |by {address}                            |
    +--------------------------------------------+----------------------------------------+
    |:[range]join                                |join the lines                          |
    +--------------------------------------------+----------------------------------------+
    |:[range]normal{commands}                    |execute normal mode {commands} on each  |
    |                                            |line                                    |
    +--------------------------------------------+----------------------------------------+
    |:[range]substitute{pattern}/{string}/[flags]|replace occurences of {pattern} with    |
    |                                            |{string} on each line                   |
    +--------------------------------------------+----------------------------------------+
    |:[range]global/{pattern}/[cmd]              |execute the ex command [cmd] on all     |
    +--------------------------------------------+----------------------------------------+
    ```
Some keymaps in ex mode are the same as insert mode, <kbd>C-w</kbd>,
<kbd>C-u</kbd>,  <kbd>C-v</kbd>,  <kbd>C-k</kbd>,  <kbd>C-r(register)</kbd>

1. Execute a Command on One or More consecutive Lines  
    ```
    <!DOCTYPE html>
    <html>
      <head><title>Practical Vim</title></head>
      <body><h1><Practical Vim></h1></body>
    </html>
    ```
    ```
    +-------------+------------------------------+
    |Symbol       |Address                       |
    +-------------+------------------------------+
    |1            |first line of the file        |
    +-------------+------------------------------+
    |$            |last line of the file         |
    +-------------+------------------------------+
    |0            |virtual line avove first line |
    +-------------+------------------------------+
    |,            |line where cursor is placed   |
    +-------------+------------------------------+
    |'m           |line containing mark m        |
    +-------------+------------------------------+
    |'<           |start of visual selection     |
    +-------------+------------------------------+
    |'>           |end of visual selection       |
    +-------------+------------------------------+
    |%            |entire file(:1,$)             |
    +-------------+------------------------------+
    ```

1. Duplicate or Move Lines Using <kbd>:t</kbd> and <kbd>:m</kbd> Commands  
    ```
    Shopping list
        hardware store
            buy new hammer
        beauty parlor
            buy nail polish remover
            buy nails
    ```

    ```
    +----------------------------------------+----------------------------------------+
    |command                                 |effect                                  |
    +----------------------------------------+----------------------------------------+
    |:t6                                     |copy current line to below line 6       |
    +----------------------------------------+----------------------------------------+
    |:t$                                     |copy current line to end of file        |
    +----------------------------------------+----------------------------------------+
    |:'<,'>t0                                |cpyt visual selection to start of file  |
    +----------------------------------------+----------------------------------------+
    ```

1. Run Normal Mode Commands Across a Range  
    ```javascript
    var foo = 1;
    var bar = `a`;
    var baz = `z`;
    var foobar = foo + bar;
    var foobarbaz = foo + bar + baz;
    ```

1. Repeat the Last Ex Command  

1. Tab-Complete Your Ex Commands  

1. Insert the Current Word at the Command Prompt  
<kbd>C-r C-w</kbd>

1. Recall Commands from History  
    ```
    +----------------------------------------+----------------------------------------+
    |command                                 |action                                  |
    +----------------------------------------+----------------------------------------+
    |q/                                      |open cmdwin with history of searches    |
    +----------------------------------------+----------------------------------------+
    |q:                                      |open cmdwin with history of Ex commands |
    +----------------------------------------+----------------------------------------+
    |ctrl-f                                  |switch from command-line mode to        |
    |                                        |cmdwin(reversely not true)              |
    +----------------------------------------+----------------------------------------+
    ```

1. Run Commands in the Shell  
differences between `:w ! {cmd}` and `:w! {cmd}`. <kbd>!G</kbd> helps to open a
prompt with `:.,$!`.
    ```
    first name, last name, email
    jane,doe,jane@example.com
    drew,neil,dress@vimcasts.org
    john,smith,john@example.com
    ```

1. Track Open Files with the Buffer List  

1. Group Buffers into a Collection with the Argument List  
`backtick` expansion can be used, `:argdo` might be useful.
```
Glob  Files Matching the Expansion
:args *.*  index.html,app.js
:args **/*.js  app.js,lib/framework.js
```

1. Manage Hidden Files  

1. Divide Your Workspace into Split Windows  
    ```
    +----------------+-----------------------------------+
    |<C-w c>         |close active window                |
    +----------------+-----------------------------------+
    |<C-w>_          |Maximize active window height      |
    +----------------+-----------------------------------+
    |<C-w>|          |Maximize active window width       |
    +----------------+-----------------------------------+
    |[N]<C-w>_       |set active window height to [N]    |
    |                |rows                               |
    +----------------+-----------------------------------+
    |[N]<C-w>_       |set active window height to [N]    |
    |                |columns                            |
    +----------------+-----------------------------------+
    ```

1. Orgnize Your Window Layouts with Tab Pages  
`:lcd{path}` set working directory locally for current window, `:windo
lcd{path}` globally
    ```
    <C-w>T  move current window into a new tab
    :tabclose  close current tab and its windows
    :tabonly  keep the active tab, close all others
    ```

1. Open a File by Its Filepath Using `:edit`  

1. Open a File by Its Filename Using `:find`  

1. Explore the File System with netrw  

1. Save a File as the Super User  

1. Keep Your Fingers on the Home Row  

1. Distinguish Between Real Lines and Display Lines  

1. Move Word-Wise  
`ge` backward to end of previous word

1. Find by Character  

1. Search to Navigate  

1. Trace Your Selection with Precision Text Objects  
    ```javascript
    var tpl = [
      '<a href="{url}">{title}</a>'
    ]
    ```

1. Delete Around, or Change Inside  

1. Mark Your Place and Snap Back to It  
    ```
    +-------------------+-----------------------------------+
    |keystrokes         |buffer contents                    |
    +-------------------+-----------------------------------+
    |``                 |position before the last jump      |
    |                   |within current file                |
    +-------------------+-----------------------------------+
    |`.                 |location of last change            |
    +-------------------+-----------------------------------+
    |`^                 |location of last insertion         |
    +-------------------+-----------------------------------+
    |`[                 |start of last change or yank       |
    +-------------------+-----------------------------------+
    |`]                 |end of last change or yank         |
    +-------------------+-----------------------------------+
    |`<                 |start of last visual selection     |
    +-------------------+-----------------------------------+
    |`>                 |end of last visual selection       |
    +-------------------+-----------------------------------+
    ```

1. Jump Between Matching Parentheses  
<kbd>%</kbd> works with `()`, `[]`, `{}`.

1. Traverse the Jump List  
<kbd>:jumps</kbd>
    ```
    +-----------------------------------+-----------------------------------+
    |command                            |effect                             |
    +-----------------------------------+-----------------------------------+
    |[count]G                           |jump to line number                |
    +-----------------------------------+-----------------------------------+
    |//pattern<CR>/?pattern/<CR>/n/N    |jump to next/previous occurrence of|
    |                                   |pattern                            |
    +-----------------------------------+-----------------------------------+
    |(/)                                |jump to start of previous/next     |
    |                                   |sentence                           |
    +-----------------------------------+-----------------------------------+
    |{/}                                |jump to start of previous/next     |
    |                                   |paragraph                          |
    +-----------------------------------+-----------------------------------+
    |'<mark>/`<mark>                    |jump to a mark                     |
    +-----------------------------------+-----------------------------------+
    ```
NOTE: <kbd>i_Ctrl-i</kbd> has the same effect as <kbd>TAB</kbd>.

1. Traverse the Change List  
<kbd>uC-r</kbd> jump back to the part of document that edited most
recently. <kbd>:changes</kbd> can be used to see changes.

1. Jump to the Filename Under the Cursor  

1. Snap Between File Using global Marks  
<kbd>:vimgrep</kbd> is usually used with mark.

1. Delete, Yank, and Put with Vim's Unnamed register  

1. Grok Vim's Registers  
    ```javascript
    collection = getCollection();
    process(collection , target);
    ```
    ```
    "+    X11 cliboard, used with cut,copy, and paste
    "*    X11 primary, used with middle mouse button(shift+ins)
    "=    read-only, used with command line mode
    "%    name of the current file
    "#    name the alternate file
    ".    last inserted text
    ":    last Ex command
    "/    last search pattern
    ```

1. Replace a Visual Selection with a Register  
    ```javascript
    collection = getCollection();
    process(collection , target);
    ```
    ```
    I like fish and chips.
    ```
    
1. Paste from a Register  

    ```javascript
    collection = getCollection();
    process(collection , target);
    ```
    NOTE:<kbd>C-r0</kbd>

1. Interact with the System Clipboard  
    ```ruby
    [1, 2, 3, 4, 5, 6, 7, 8, 9. 10].each do |n|
      if n % 5 == 0
        puts "fizz"
      else
        puts n
      end
    end
    ```
    
1. Record and Execute a Macro[TODO]  

    ```javascript
    foo = 1
    bar = `a`
    foobar = foo + bar
    ```

1. Normalize, Strike, Abort[TODO]  

1. Play Back with a Count[TODO]  

1. Repeat a Change on Contiguous Lines [TODO]  

1. Append Command to a Macro[TODO]  

1. Act Upon a Collections of Files[TODO]  

1. Evaluate an Iterator to Number Iterms in a List[TODO]  

1. Edit the Contents of a Macro[TODO]  

1. Tune the Case Sensitivity of Search Patterns  

    1. <kbd>\c</kbd> ignore case sensitive
    1. <kbd>\C</kbd> case sensitive

1. Use the \v Pattern Switch for Regex Searches  

    1. <kbd>\v</kbd> `'0'-'9', 'a'-'z', 'A'-'Z', '_'` "very magic"
    1. <kbd>\V</kbd> pattern after it,only `\` has special meaning
    
1. Use the \V Literal Switch for Verbatim Searches  

1. Use Parentheses to Capture Submatches(TODO)  
    ```I love Paris in the
    the spring time.
    ```

1. Stake the Boundaries of a Word(TODO)  

1. Stake the Boundaries of a Match(TODO)__

1. Escape Problem Characters(TODO)  

1. Meet the Search Command  

1. Highlight Search Matches  

1. Preview the First Match Before Execution  
Go back where we are before search:<kbd>Esc</kbd>;autocomplete the search
field:<kbd>C-r C-w</kbd>

1. Count the Matches for the Current Pattern: `:%s///gn`

1. Offset the curosr to the End of a Search Match  
```
Aim to learn a new programmming language each year.
Which language did you pick up last year?
Which languages would you like to learn?
```
`/lang/e<CR>` and `.` to append _uage_ to _lang/langs_ .

1. Operate on a Complete Search Match(TODO)  
```ruby
class XhtmlDocument < XmlDocument; end
class XhtmlTag < XmlTag; end
```

1. Create Complex Patterns by Iterating upon Search History(TODO)  
```
This string contains a 'quoted' word.
This string contains "two" quoted "word".
This "string doesn't make things easy".   #vim-surround would fail on this sentence!
```

1. Search for the Current Visual Selection  
```
She sells sea shells by the sea shore.
```
