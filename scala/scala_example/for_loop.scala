def forLoop{
    println("for loop using java-style iteration")
    for(i<-0 until args.length)
        println(args(i))
}

def rubyStyleForLoop{
    println("for loop using ruby-style iteration")
    args.foreach(arg=>println(arg))
}

forLoop
rubyStyleForLoop
