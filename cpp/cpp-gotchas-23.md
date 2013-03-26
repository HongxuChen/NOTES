###Gotcha 23: Operator Function Lookup Anomaly

```c++
class X { 
 public:
   X &operator %( const X & ) const;
   void f();
   // . . .
};
X &operator %( const X &, int );
void X::f() {
   X &anX = *this;
   anX % 12; // OK, non-member
   operator %( anX, 12 ); // error!
}
```
