1. typename is _prohibited_ in each of the following scenarios:
  1. Outside of a template definition. (Be aware: an explicit template specialization (more commonly called a total specialization, to contrast with partial specializations) is not itself a template, because there are no missing template parameters! Thus typename is always prohibited in a total specialization.)
  1. Before an unqualified type, like int or my_thingy_t.
  1. When naming a base class.
  
  ```c++
  template <class C>
  class my_class : C::some_base_type  // should not be `typename C::some_base_type'
  {
   ... 
  };
  ```

1. In a constructor initialization list.
 1. typename is _mandatory_ before a qualified, dependent name which refers to a type (unless that name is naming a base class, or in an initialization list).
 1. typename is _optional_ in other scenarios.
It is optional before a qualified but non-dependent name used within a template, except again when naming a base class or in an initialization list.)
