class Person(val name: String)
{
    def talk(message:String) = println(name + "says" + message)
    def id(): String = name
}

class Employee(override val name:String,val number:Int) extends Person(name){
    override def talk(message:String){
        println(name+" with number " + number + " says " + message)
    }
//    override def id():String = number.toString
}

val employee = new Employee("yoda",4)
employee.talk("extend or extend not.there is no try.")
println(employee.id())
