from llvm import *
from llvm.core import *

m = Module.new('lisp')
main = m.add_function(Type.function(Type.int(), []), "main")
main_block = main.append_basic_block('entry')
b = Builder.new(main_block)

class ReferenceNotFound(Exception):
    pass

class Env(object):
    def __init__(self,parent=None):
        self.parent = parent
        self.locals = {}

    def set(self,k,v):
        self.locals[k] = v

    def get(self,k):
        try:
            return self.locals[k]
        except KeyError:
            if self.parent:
                return self.parent.get(k)
            else:
                raise ReferenceNotFound


def prim_add():
    f = m.add_function(Type.function(Type.int(), [Type.int(), Type.int()]), 'prim_add')
    block = f.append_basic_block('entry')
    builder = Builder.new(block)
    tmp = builder.add(f.args[0], f.args[1], 'tmp')
    builder.ret(tmp)
    return f

def prim_sub():
    f = m.add_function(Type.function(Type.int(), [Type.int(), Type.int()]), 'prim_sub')
    block = f.append_basic_block('entry')
    builder = Builder.new(block)
    tmp = builder.sub(f.args[0], f.args[1], 'tmp')
    builder.ret(tmp)
    return f

primitives = {
    '+': prim_add(),
    '-': prim_sub()
}

def immediate(sexp):
    if type(sexp) == int:
        return True
    else:
        return False

def immediate_rep(sexp, builder):
    if type(sexp) == int:
        return ConstantInt.int(Type.int(), sexp)

def prim_call(sexp):
    if type(sexp) == list and len(sexp) > 0 and type(sexp[0]) == str and sexp[0] in primitives:
        return True
    else:
        return False

def prim_op(op, args, builder):
    return builder.call(primitives[op], args)

def define(args, builder, env):
    name = args[0]
    value = compile(args[1], builder, env)
    env.set(name, value)

lambda_counter = 0

def lambdaf(args,builder,env):
    arglist = args[0]
    body = args[1]

    argtypes = [Type.int() for a in arglist]

    f_env = Env(env)

    f = m.add_function(Type.function(Type.int(), argtypes), 'f%d' % lambda_counter)
    for arg,name in zip(f.args, arglist):
        arg.name = name
        f_env.set(name, arg)

    block = f.append_basic_block('entry')
    f_builder = Builder.new(block)

    last = compile_block(body, f_builder, f_env)
    f_builder.ret(last)

    return f
    

special_forms = {
    'def': define,
    'lambda': lambdaf
}

def special(sexp):
    return type(sexp) == list and type(sexp[0]) == str and sexp[0] in special_forms

def special_op(sexp, builder, env):
    return special_forms[sexp[0]](sexp[1:], builder, env)

def variable(sexp):
    if type(sexp) == str:
        return True
    else:
        return False

def variable_ref(sexp, env):
    #return m.get_global_variable_named(sexp).initializer
    return env.get(sexp)


def call(sexp):
    return type(sexp) == list and type(sexp[0]) == str

def call_op(name, args, builder, env):
    #f = m.get_function_named(name)
    f = env.get(name)
    return builder.call(f, args)

def compile(sexp, builder, env):
    if immediate(sexp):
        return immediate_rep(sexp, builder)
    elif special(sexp):
        return special_op(sexp, builder, env)
    elif prim_call(sexp):
        args = [compile(arg, builder, env) for arg in sexp[1:]]
        return prim_op(sexp[0], args, builder)
    elif variable(sexp):
        return variable_ref(sexp, env)
    elif call(sexp):
        args = [compile(arg, builder, env) for arg in sexp[1:]]
        return call_op(sexp[0], args, builder, env)


def compile_block(sexps, builder, env):
    statements = [compile(sexp, builder, env) for sexp in sexps]
    return statements[-1]

if __name__ == "__main__":

    raw = [['def', 'x', 43],
           ['def', 'y', 11],
           ['def', 'z', ['+', 'y', 3]],
           ['def', 'calculate',
            ['lambda', ['a', 'b'],
             [['+', ['-', 'a', 38], 'b']]]],
           ['calculate', 'x', 'z']]


    last = compile_block(raw, b, Env())
    b.ret(last)
    print m
