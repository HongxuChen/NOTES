import scala.actors._
import scala.actors.Actor._

case object Poke
case object Feed

class Kid extends Actor {
  def act() {
    loop {
      react {
        case Poke => {
          println("quit")
        }
        case Feed => {
          println("Burp")
        }
      }
    }
  }
}

val bart = new Kid().start()
val lisa = new Kid().start()
println("========================")
bart ! Poke
lisa ! Poke
bart ! Feed
lisa ! Feed
