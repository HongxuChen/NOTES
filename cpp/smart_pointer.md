* Once smart pointers are generated, they no longer know the existence of the raw pointers; so it's better to set these raw pointers to point to other areas(typically `nullptr`) to avoid mistakes.
* The poblem is about `alias` analysis and it's hard to make smart pointers even smarter.
* Don't use construct `std::shared_ptr` with raw pointers that's already managed by other `std::shared_ptr` since shared pointer only know the existence of other shared pointers; for raw pointers, they cannot do any guess.
* `std::shared_ptr` works for both *heap* and *stack* objects; `std::make_shared` only for *heap* ones.
* `std::make_shared` is exception-safe and may be less costly with further compile optimization.
