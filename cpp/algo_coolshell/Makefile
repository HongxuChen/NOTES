CC = gcc
CFLAGS = -Wall -O2
DEBUGFLAGS = -g

main : main.o list.o

bench : main
	valgrind --tool=cachegrind --cachegrind-out-file=linus.out \
		     ./main 1000000 --linus
	valgrind --tool=cachegrind --cachegrind-out-file=other.out \
		     ./main 1000000 --other
	cg_merge -o merged.out linus.out other.out
	rm linus.out other.out
	cg_annotate merged.out | less

%.o : %.c list.h
	$(CC) -c $< -o $@ $(CFLAGS) $(DEBUGFLAGS)

%.S : %.c list.h
	$(CC) -c $< -o $@ -S $(CFLAGS)

clean :
	rm main main.o list.o list.S merged.out

