* online book: <http://infohost.nmt.edu/~eweiss/222_book/222_book/0201433079/toc.html>

###1.2. UNIX architecture
![Architecture of the UNIX operating system](http://infohost.nmt.edu/~eweiss/222_book/222_book/0201433079/images/0201433079/graphics/01fig01.gif;423615)

###1.3. Logging in
password file:`/etc/passwd`;e.g.`hongxuchen:x:1000:1000:hongxuchen,,,:/home/hongxuchen:/bin/bash`
- login name
- encrypted password
- numeric user ID
- numeric group ID
- comment field
- home directory
- shell program

Notes:To get the shell I am using:
```bash
cat /etc/passwd|egrep -w ^`whoami` |cut -d: -f7
```

###1.4. Files and Directories
filename:any chars except `/` and `null`; name for root(`/`) is a special-case absolute pathname that has no filename component.

###1.5. Input and Output
Unbuffered I/O is provided by the functions `open`, `read`, `write`, `lseek`, and `close`. These functions all work with file descriptors.

###1.6. Programs and Processes
- Usually, a process has only one thread of controlone set of machine instructions executing at a time.
- All the threads within a process share the same address space, file descriptors, stacks, and process-related attributes.
- Thread IDs, however, are local to a process.

###1.7. Error Handling
- On Linux, the error constants are listed in the `errno(3)` manual page.
- 2 rules with respect to errno
  - Its value is never cleared by a routine if an error does not occur. Therefore, we should examine its value only when the return value from a function indicates that an error occurred. 
  - The value of errno is never set to 0 by any of the functions, and none of the constants defined in `<errno.h>` has a value of 0.
- Error Recovery
  - fatal:no recovery action
  - nonfatal: `EAGAIN`, `ENFILE`, `ENOBUFS`, `ENOLCK`, `ENOSPC`, `ENOSR`, `EWOULDBLOCK`, and sometimes `ENOMEM`,`EBUSY`,`EINTR`

###1.9. Signals
- Signals are a technique used to notify a process that some condition has occurred.
- The process has three choices for dealing with the signal.
  - Ignore the signal.
  - Let the default action occur.
  - "Catch" the signal.

###1.10. Time Values
1. Calendar time,`time_t`
2. Process time(CPU time),measured in clock ticks, which have historically been 50, 60, or 100 ticks per second,`clock_t`
  - Clock time
  - User CPU time
  - System CPU time

###1.11. System Calls and Library Functions
- All implementations of the UNIX System provide a well-defined, limited number of entry points directly into the kernel called __system calls__.
- Library functions can be replaced,system calls cannot.
- System calls provide a minimal interface, library functions more elaborate functionality

e.g. Separation of malloc function and sbrk system call  

![Separation of malloc function and sbrk system call](http://infohost.nmt.edu/~eweiss/222_book/222_book/0201433079/images/0201433079/graphics/01fig11.gif;423615)
