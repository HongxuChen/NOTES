## SRC

```c
// SimpleSection.c

#include<stdio.h>

int global_init_var = 84;
int global_uninit_var;

void func1(int i) {
    printf("%d\n", i);
}

int main(int argc, char *argv[])
{
    static int static_var = 85;
    static int static_var2;

    int a = 1;
    int b;

    func1(static_var + static_var2 +  a + b);
    return 0;
}

```

## OBJECT FILE

```bash
gcc -c SimpleSection.c #emit SimpleSection.o

```

### objdump
` objdump -h SImpleSection.o `, this would output the followings:

```bash
Sections:
Idx Name          Size      VMA               LMA               File off  Algn
  0 .text         0000005c  0000000000000000  0000000000000000  00000040  2**2        # code section
                  CONTENTS, ALLOC, LOAD, RELOC, READONLY, CODE                        
  1 .data         00000008  0000000000000000  0000000000000000  0000009c  2**2        # data section
                  CONTENTS, ALLOC, LOAD, DATA                                         
  2 .bss          00000004  0000000000000000  0000000000000000  000000a4  2**2        # Block Started by Symbol
                  ALLOC                                                               
  3 .rodata       00000004  0000000000000000  0000000000000000  000000a4  2**0        # readonly data
                  CONTENTS, ALLOC, LOAD, READONLY, DATA                               
  4 .comment      0000002b  0000000000000000  0000000000000000  000000a8  2**0        # comments
                  CONTENTS, READONLY                                                  
  5 .note.GNU-stack 00000000  0000000000000000  0000000000000000  000000d3  2**0      # stack section
                  CONTENTS, READONLY                                                  
  6 .eh_frame     00000058  0000000000000000  0000000000000000  000000d8  2**3        # exception handling
                  CONTENTS, ALLOC, LOAD, RELOC, READONLY, DATA

```
We can also use `-x` to get more information of the object.

### size
There is a command called `size` to view ELF file's data/text/BSS size, `size SimpleSection.o`

```bash
text	   data	    bss	    dec	    hex	filename
 184	      8	      4	    196	     c4	SimpleSection.o
```

## DATA and RODATA

```bash
SimpleSection.o:     file format elf64-x86-64

Contents of section .text:
 0000 554889e5 4883ec10 897dfcb8 00000000  UH..H....}......
 0010 8b55fc89 d64889c7 b8000000 00e80000  .U...H..........
 0020 0000c9c3 554889e5 4883ec20 897dec48  ....UH..H.. .}.H
 0030 8975e0c7 45f80100 00008b15 00000000  .u..E...........
 0040 8b050000 000001d0 0345f803 45fc89c7  .........E..E...
 0050 e8000000 00b80000 0000c9c3           ............    
Contents of section .data:
 0000 54000000 55000000                    T...U...        
Contents of section .rodata:
 0000 25640a00                             %d..            
Contents of section .comment:
 0000 00474343 3a202855 62756e74 752f4c69  .GCC: (Ubuntu/Li
 0010 6e61726f 20342e36 2e332d31 7562756e  naro 4.6.3-1ubun
 0020 74753529 20342e36 2e3300             tu5) 4.6.3.     
Contents of section .eh_frame:
 0000 14000000 00000000 017a5200 01781001  .........zR..x..
 0010 1b0c0708 90010000 1c000000 1c000000  ................
 0020 00000000 24000000 00410e10 8602430d  ....$....A....C.
 0030 065f0c07 08000000 1c000000 3c000000  ._..........<...
 0040 00000000 38000000 00410e10 8602430d  ....8....A....C.
 0050 06730c07 08000000                    .s......        

Disassembly of section .text:

0000000000000000 <func1>:
   0:	55                   	push   %rbp
   1:	48 89 e5             	mov    %rsp,%rbp
   4:	48 83 ec 10          	sub    $0x10,%rsp
   8:	89 7d fc             	mov    %edi,-0x4(%rbp)
   b:	b8 00 00 00 00       	mov    $0x0,%eax
  10:	8b 55 fc             	mov    -0x4(%rbp),%edx
  13:	89 d6                	mov    %edx,%esi
  15:	48 89 c7             	mov    %rax,%rdi
  18:	b8 00 00 00 00       	mov    $0x0,%eax
  1d:	e8 00 00 00 00       	callq  22 <func1+0x22>
  22:	c9                   	leaveq 
  23:	c3                   	retq   

0000000000000024 <main>:
  24:	55                   	push   %rbp
  25:	48 89 e5             	mov    %rsp,%rbp
  28:	48 83 ec 20          	sub    $0x20,%rsp
  2c:	89 7d ec             	mov    %edi,-0x14(%rbp)
  2f:	48 89 75 e0          	mov    %rsi,-0x20(%rbp)
  33:	c7 45 f8 01 00 00 00 	movl   $0x1,-0x8(%rbp)
  3a:	8b 15 00 00 00 00    	mov    0x0(%rip),%edx        # 40 <main+0x1c>
  40:	8b 05 00 00 00 00    	mov    0x0(%rip),%eax        # 46 <main+0x22>
  46:	01 d0                	add    %edx,%eax
  48:	03 45 f8             	add    -0x8(%rbp),%eax
  4b:	03 45 fc             	add    -0x4(%rbp),%eax
  4e:	89 c7                	mov    %eax,%edi
  50:	e8 00 00 00 00       	callq  55 <main+0x31>
  55:	b8 00 00 00 00       	mov    $0x0,%eax
  5a:	c9                   	leaveq 
  5b:	c3                   	retq   
```
# ELF format

ELF header in linux is located is `/usr/include/elf.h`

### readelf

```bash
ELF Header:
  Magic:   7f 45 4c 46 02 01 01 00 00 00 00 00 00 00 00 00 
  Class:                             ELF64
  Data:                              2's complement, little endian
  Version:                           1 (current)
  OS/ABI:                            UNIX - System V
  ABI Version:                       0
  Type:                              REL (Relocatable file)
  Machine:                           Advanced Micro Devices X86-64
  Version:                           0x1
  Entry point address:               0x0
  Start of program headers:          0 (bytes into file)
  Start of section headers:          408 (bytes into file)
  Flags:                             0x0
  Size of this header:               64 (bytes)
  Size of program headers:           0 (bytes)
  Number of program headers:         0
  Size of section headers:           64 (bytes)
  Number of section headers:         13
  Section header string table index: 10
```

```bash
There are 13 section headers, starting at offset 0x198:

Section Headers:
  [Nr] Name              Type             Address           Offset
       Size              EntSize          Flags  Link  Info  Align
  [ 0]                   NULL             0000000000000000  00000000
       0000000000000000  0000000000000000           0     0     0
  [ 1] .text             PROGBITS         0000000000000000  00000040
       000000000000005c  0000000000000000  AX       0     0     4
  [ 2] .rela.text        RELA             0000000000000000  000006c0
       0000000000000078  0000000000000018          11     1     8
  [ 3] .data             PROGBITS         0000000000000000  0000009c
       0000000000000008  0000000000000000  WA       0     0     4
  [ 4] .bss              NOBITS           0000000000000000  000000a4
       0000000000000004  0000000000000000  WA       0     0     4
  [ 5] .rodata           PROGBITS         0000000000000000  000000a4
       0000000000000004  0000000000000000   A       0     0     1
  [ 6] .comment          PROGBITS         0000000000000000  000000a8
       000000000000002b  0000000000000001  MS       0     0     1
  [ 7] .note.GNU-stack   PROGBITS         0000000000000000  000000d3
       0000000000000000  0000000000000000           0     0     1
  [ 8] .eh_frame         PROGBITS         0000000000000000  000000d8
       0000000000000058  0000000000000000   A       0     0     8
  [ 9] .rela.eh_frame    RELA             0000000000000000  00000738
       0000000000000030  0000000000000018          11     8     8
  [10] .shstrtab         STRTAB           0000000000000000  00000130
       0000000000000061  0000000000000000           0     0     1
  [11] .symtab           SYMTAB           0000000000000000  000004d8
       0000000000000180  0000000000000018          12    11     8
  [12] .strtab           STRTAB           0000000000000000  00000658
       0000000000000066  0000000000000000           0     0     1
Key to Flags:
  W (write), A (alloc), X (execute), M (merge), S (strings), l (large)
  I (info), L (link order), G (group), T (TLS), E (exclude), x (unknown)
  O (extra OS processing required) o (OS specific), p (processor specific)
```

