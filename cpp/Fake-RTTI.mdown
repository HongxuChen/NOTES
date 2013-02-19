[LLVM coding standards](http://llvm.org/docs/CodingStandards.html#do-not-use-rtti-or-exceptions) discourages the usage of [RTTI](http://en.wikipedia.org/wiki/Run-time_type_information), from the `Makefile.rules` we can see that there is an additional option called `-fno-rtti` when building LLVM. As there are rather complicated class hierarchy in llvm src, the remedy is [The isa<>, cast<> and dyn_cast<> templates](http://llvm.org/docs/ProgrammersManual.html#the-isa-cast-and-dyn-cast-templates) and the implement is like below:

```c++
namespace RTTI {
enum BaseId {
    RightId, L1Id, L2Id, DerivedRId
};
struct Base { //abstract
    BaseId Id;
    Base(BaseId id) :
            Id(id) {
    }
    BaseId getValueId() const {
        return Id;
    }
};
struct Left: Base { //abstract
    Left(BaseId id) :
            Base(id) {
    }
};
struct Left1: Left {
    Left1(BaseId id = L1Id) :
            Left(id) {
    }
    static inline bool classof(Left1 const* L1) {
        return true;
    }
    static inline bool classof(Left const* L) {
        return L->getValueId() == L1Id;
    }
    static inline bool classof(Base const* B) {
        return B->getValueId() == L1Id;
    }
};
struct Left2: Left {
    Left2(BaseId id = L2Id) :
            Left(id) {
    }
    static inline bool classof(Left2 const* L2) {
        return true;
    }
    static inline bool classof(Left const* L) {
        return L->getValueId() == L2Id;
    }
    static inline bool classof(Base const* B) {
        return B->getValueId() == L2Id;
    }
};
struct Right: Base {
    Right(BaseId id = RightId) :
            Base(id) {
    }
    static inline bool classof(Right const* R) {
        return true;
    }
    static inline bool classof(Base const* B) {
        return B->getValueId() == RightId || B->getValueId() == DerivedRId;
    }

};
struct DerivedR: Right {
    DerivedR(BaseId id = DerivedRId) :
            Base(id) {
    }
    static inline bool classof(DerivedR const* DR) {
        return true;
    }
    static inline bool classof(Right const* R) {
        return R->getValueId() == DerivedRId;
    }
    static inline bool classof(Base const* B) {
        return B->getValueId() == DerivedRId;
    }
};

template<typename To, typename From>
bool isa(From const& f) {
    return To::classof(&f);
}
}//end of namespace RTTI
```
A drive program may display the effect:

```c++
#include<assert.h>
using namespace RTTI;
int main() {
    Left1 l1;
    Right r;
    DerivedR dr;
    Base *pb = &l1;
    assert(isa<Left1>(*pb) && "l1 should isa Left1");
    assert(!isa<Left2>(*pb) && "l1 should not isa Left2");
//    assert(isa<Left>(*pb) && "should be compile error");
    pb = &r;
    assert(isa<Right>(*pb) && "r should isa Right");
    Right *pr = &dr;
    assert(isa<DerivedR>(*pr) && "dr should isa DerivedR");
    assert(isa<Right>(*pr) && "dr should isa Right");
    return 0;
}
```
