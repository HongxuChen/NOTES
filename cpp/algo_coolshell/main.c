#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"

static long
succLong(long i) {
    return i + 1;
}

static void
printLong(long i) {
    printf("%ld", i);
}

static int
isEven(long i) {
    return !(i & 1);
}

int
main(int argc, char **argv) {
    if (argc != 3) {
        return 1;
    }

    long enumTo = atoi(argv[1]);
    int isLinus = strcmp(argv[2], "--linus") == 0;

    Node *node = enumFromTo((void *) succLong, (void *) 1, (void *) enumTo);
    //printList((void *) printLong, node);

    if (isLinus)
        node = filterLinus((void *) isEven, node);
    else
        node = filterOther((void *) isEven, node);
    //printList((void *) printLong, node);

    //freeList(NULL, node);
    return 0;
}

