class Person(first_name:String){
//    println("outer constructor")
    def this(first_name:String,last_name:String)
    {
        this(first_name)
        println("inner constructor")
    }

    def talk()=println("hello")
}

val bob = new Person("bob")
// wrong
//println bob.first_name
val bobTate = new Person("bob","tate")

