class person(val name:String){
    def getName():String=name
}
trait Nice{
    def greet()=println("hongxu chen")
}


class Character(override val name:String) extends person(name) with Nice


val flanders = new Character("Ned")
flanders.greet
println(flanders.getName)
