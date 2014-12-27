```bash
tr [OPTION] SET1 [SET2]  
CHAR1-CHAR2,[CHAR*],[CHAR*REPEAT],[:alnum:],[:alpha:],[:blank:],[:cntrl:],[:digit:],[:graph:],[:lower:],[:print:],[:punct:],[:space:],[:upper:],[:xdigit:]
```

###interactive mode

- tr abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ
- tr [:lower:] [:upper:]
- tr a-z A-Z

###pipe mode

- tr '{}' '()' < inputfile > outputfile
- echo  -e "This\t is for or testing" | tr [:space:] | wc -l
- echo "my number is 19890806" | tr -d [:digit:]
- echo "my number is 19890806" | tr -cd [:digit:]
