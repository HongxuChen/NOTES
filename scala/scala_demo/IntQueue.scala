import scala.collection.mutable.ArrayBuffer
object QueueTest extends App {
    val arrayBuffer = ArrayBuffer(1,1)
    var queue:IntQueue = new BasicIntQueue(arrayBuffer)
    queue.put(2)
    println(queue)

    queue = new MyQueue(arrayBuffer) with Factorial
    queue.put(3)
    println(queue)
}

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
  override def toString() = "Oops,abstract class IntQueue"
}

class BasicIntQueue(arrBuf: ArrayBuffer[Int]) extends IntQueue {
  val buf = arrBuf
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
  override def toString() = {
    "Queue1 " + buf.toString
  }
}

trait Factorial extends IntQueue {
  abstract override def put(x: Int) { super.put(fac(x)) }
  def fac(i: Int): Int = { 
    if (i == 0 || i == 1) 1;
    else fac(i - 1) * i
  }
}

class MyQueue(arrBuf: ArrayBuffer[Int]) extends BasicIntQueue(arrBuf: ArrayBuffer[Int]) {
  override def toString() = {
    "Queue2 " + buf.toString
  }
}