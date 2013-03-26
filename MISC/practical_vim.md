1. DOT 

    ```
    line one
        line two
            line three
                line four
    ```

1. DRY

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
   Make changes repleatable so `.` can be used

1. Meet the Dot Formula
