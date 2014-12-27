1. `inline` in c++
 1. used with _static_ in c++
 1. *defined* in header files
 1. default if the function is defined inner Class
 1. inline function can be defined several times
 1. if interface separation is adapted, both declaration and definition need the keyword

1. always use expression without side effect in `assert` macro

1. construct member variable in order they defined(`-Wreorder`)

1. `mutable` and `volatile`
 1. `mutable` is related to *const*, a member of a class
 1. mutable field can be changed even in an object accessed through a `const` pointer or reference, or in a `const` object
 1. the compiler KNOWS when a mutable object changes.
 1. `volatile` is related to *register*
 1. compiler prevent `volatile` variable from being put into register
 1. `volatile` location is one that can be changed by code the compiler DOESN'T know(e.g. some kernel-level driver)

1. CV(const-volatility) specifiers(http://en.cppreference.com/w/cpp/language/cv)
 1. const
 1. volatile
 1. mutable
