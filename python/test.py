#!/usr/bin/python
import llvm.core as lc
import llvm.passes as lp
# import llvm.ee as le

# basic objects
void_t = lc.Type.int()
int_t = int64_t = lc.Type.int(64)
int32_t = lc.Type.int(32)
int8_t = lc.Type.int(8)
int8p_t = lc.Type.pointer(int8_t)
zero = lc.Constant.int(int64_t, 0)

# build module
module = lc.Module.new("hello")
# add libs
# module.add_library("c")
puts_t = lc.Type.function(int_t, [int8p_t])
puts = module.add_function(puts_t, "puts")

# define function body
hello_t = lc.Type.function(void_t, [])
hello = module.add_function(hello_t, "main")
hello_entry = hello.append_basic_block("entry")
builder = lc.Builder.new(hello_entry)

# make constant string
hello_data = lc.Constant.stringz("hello world") # \0 terminated array
hello_array = module.add_global_variable(hello_data.type, "hello_str")
hello_array.initializer = hello_data
hello_str = hello_array.gep([zero, zero]) # GetElementPointer [itself=0,idx=0]

# call puts
puts_r = builder.call(puts, [hello_str], "puts_r")

# return void
builder.ret_void()

# (option) optimize
pm = lp.PassManager.new()
# pmb = lp.PassManagerBuilder.new()
# pmb.populate(pm)
# pm.run(module)

# dump module
print(module)

# execute function
# engine = le.ExecutionEngine.new(module)
# engine.run_function(hello, [])
# values are le.GenericValue: only support int, real and their pointers
# (not support array and str)
