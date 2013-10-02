typedef struct node {
    void        *hd;
    struct node *tl;
} Node;

typedef void *(*SuccFn)    (void *);
typedef void  (*PrintFn)   (void *);
typedef int   (*ToBoolFn)  (void *);
typedef void  (*DeallocFn) (void *);

Node *mkNode(void *, Node *);

Node *enumFromTo(SuccFn, void *, void *);

void printList(PrintFn, Node *);

void freeList(DeallocFn, Node *);

Node *filterOther(ToBoolFn, Node *);
Node *filterLinus(ToBoolFn, Node *);

