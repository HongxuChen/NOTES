###Mode switch

|keystroke     |function
|:------------:|:-----------------------------|
| ESC          | Switch to command mode.
| i            | Insert before cursor.
| a            | Insert after cursor.
| I            | Insert at the beginning of line.
| A            | Insert at the end of line.
| c<mov. comm> | Change text of a movement command <mov. comm> (see below).
| C            | Change text to the end of line (equivalent to c$).
| cc _or_ S      | Change current line (equivalent to 0c$).
| s            | Delete a single character under the cursor and enter input mode (equivalent to c[SPACE]).
| r            | Replaces a single character under the cursor (without leaving command mode).
| R            | Replaces characters under cursor.
| v            | Edit (and execute) the current command in the text editor.  (an editor defined in $VISUAL or $EDITOR variables, or vi

###Basic Movement Commands (command mode):

|keystroke     |function
|:------------:|:-----------------------------|
| h            | Move one character right.
| l            | Move one character left.
| w            | Move one word or token right.
| b            | Move one word or token left.
| W            | Move one non-blank word right.
| B            | Move one non-blank word left.
| e            | Move to the end of the current word.
| E            | Move to the end of the current non-blank word.
| 0            | Move to the beginning of line
| ^            | Move to the first non-blank character of line.
| $            | Move to the end of line.
| %            | Move to the corresponding opening/closing bracket.


###Character Finding Commands (also Movement Commands):

|keystroke     |function
|:------------:|:-----------------------------|
| fc           | Move right to the next occurance of char c.
| Fc           | Move left to the previous occurance of c.
| tc           | Move right to the next occurance of c, then one char backward.
| Tc           | Move left to the previous occurance of c, then one char forward.
| ;            | Redo the last character finding command.
| ,            | Redo the last character finding command in opposite direction.
| |            | Move to the n-th column (you may specify the argument n by typing it on number keys, for example, 20|)

###Deletion Commands:

|keystroke     |function
|:------------:|:-----------------------------|
| x            | Delete a single character under the cursor.
| X            | Delete a character before the cursor.
| d<mov. comm> | Delete text of a movement command <mov. comm> (see above).
| D            | Delete to the end of the line (equivalent to d$).
| dd           | Delete current line (equivalent to 0d$).
| CTRL-w       | Delete the previous word.
| CTRL-u       | Delete from the cursor to the beginning of line.

##Undo, Redo and Copy/Paste Commands:

|keystroke     |function
|:------------:|:-----------------------------|
| u            | Undo previous text modification.
| U            | Undo all previous text modifications.
| .            | Redo the last text modification.
| y<mov. comm> | Yank a movement into buffer (copy).
| yy           | Yank the whole line.
| p            | Insert the yanked text at the cursor.
| P            | Insert the yanked text before the cursor.


##Commands for Command History:

|keystroke     |function
|:------------:|:-----------------------------|
| k            | Insert the yanked text before the cursor.
| j            | Insert the yanked text before the cursor.
| G            | Insert the yanked text before the cursor.
|/string _or_ CTRL-r| Search history backward for a command matching string.
| ?string      | Search history forward for a command matching string.
| n            | Repeat search in the same direction as previous.
| N            | Repeat search in the opposite direction as previous.

###Completion commands(bash-completion):

|keystroke     |function
|:------------:|:-----------------------------|
| TAB _or_ CTRL-i  | List all possible completions.
| *            | Insert all possible completions.


###Miscellaneous commands:

|keystroke     |function
|:------------:|:-----------------------------|
| ~            | Invert case of the character under cursor and move a character right.
| #            | Prepend '#' (comment character) to the line and send it to the history.
| _            | Inserts the n-th word of the previous command in the current line.
| 0, 1, 2, ... | Sets the numeric argument.
| CTRL-v       | Insert a character literally (quoted insert).
| CTRL-r       | Transpose (exchange) two characters.