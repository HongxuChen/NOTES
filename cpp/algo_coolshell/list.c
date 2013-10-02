#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>

#include "list.h"

Node *
mkNode(void *hd, Node *tl) {
    Node *res;
    res = malloc(sizeof(*res));
    res->hd = hd;
    res->tl = tl;
    return res;
}

static Node *
reverse1(Node *from, Node *to) {
    if (from == NULL) {
        return to;
    }
    else {
        void *hd = from->hd;
        Node *tl = from->tl;
        free(from);
        return reverse1(tl, mkNode(hd, to));
    }
}

Node *
enumFromTo(SuccFn succ, void *from, void *to) {
    Node *res = NULL;
    while (from != to) {
        res = mkNode(from, res);
        from = succ(from);
    }
    res = mkNode(to, res);
    return reverse1(res, NULL);
}

void
printList(PrintFn prnFn, Node *xs) {
    Node *orig = xs;
    printf("[");
    while (xs) {
        if (xs != orig) {
            printf(",");
        }
        prnFn(xs->hd);
        xs = xs->tl;
    }
    printf("]\n");
}

static int
constFalse(void *unused) {
    return 0;
}

void
freeList(DeallocFn dealloc, Node *node) {
}

Node *
filterOther(ToBoolFn toBool, Node *node) {
    Node *result = NULL;
    Node *prev = NULL;
    while (node) {
        if (toBool(node->hd)) {
            // Link to result
            if (!result) {
                prev = result = node;
            }
            else {
                prev->tl = node;
                prev = node;
            }
            node = node->tl;
        }
        else {
            Node *toDel = node;
            node = node->tl;

            free(toDel);
        }
    }
    return result;
}

Node *
filterLinus(ToBoolFn toBool, Node *node) {
    Node **result = &node;

    Node **currRef = result;
    Node *curr;
    while ((curr = *currRef)) {
        if (toBool(curr->hd)) {
            // Continue
            currRef = &curr->tl;
        }
        else {
            *currRef = curr->tl;
            free(curr);
        }
    }
    return *result;
}
