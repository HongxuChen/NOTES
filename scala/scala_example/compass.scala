class Compass{
    val directions = List("north","east","south","west")
    var bearing = 0
    print("Initial bearing:")
    println(directions)


    def direction()=directions(bearing)

    def inform(turnDirection:String){
        println("Turning:"+turnDirection+". now bearing "+direction)
    }

    def turnRight(){
        bearing = (bearing+1) % directions.size
        inform("right")
    }

    def turnLeft(){
        bearing = (bearing-1)%directions.size
        inform("left")
    }

}

val myCompass = new Compass

myCompass.turnRight
myCompass.turnLeft
