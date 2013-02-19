### Gotcha 14: Evaluation Order Indecision
Operators that fix evaluation order:  

- comma operator(generally only used in the third expression of `for` statement)  
- ternary conditional operator  
- logical operator `&&` and `||`    
__Notes__:User overrided logical operators does not have to be _short-circuiting_, which may lead to bugs;ternary conditional operator overriding is not permitted.

```c++
#include<iostream>

class Thing {
    int i;
public:
    Thing(int i= 0) :
            i(i) {
    }
    const int getInt() const{
        return i;
    }
    void setInt(int i) {
        this->i = i;
    }
};

std::ostream& operator<<(std::ostream &out, Thing &t){
    out<<t.getInt()<<" ";
    return out;
}

bool operator &&(const Thing &t1, Thing &t2) {
    if (!t1.getInt()) {
        if(!t2.getInt()){
            return false;
        }
        else{
            t2.setInt(0);
            return true;
        }
    }
    return true;
}

int main(){
    Thing t1;
    Thing t2(3);
    std::cout<<t1<<t2<<std::endl;  //0 3
    if(t1 && t2){
        std::cout<<"at least one of t1 and t2 is/are non-zero"<<std::endl;
    }
    else
        std::cout<<"t1 and t2 both equals zero"<<std::endl; //output
    std::cout<<t1<<t2<<std::endl;  // 0 0
}
```
