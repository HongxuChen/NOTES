object Modexp {
  def modExp(x: Int, y: Int, N: Int): Int = {
    if (y == 0) return 1
    val z = modExp(x, y / 2, N)
    if (y % 2 == 0)
      return z * z % N
    else return x * z * z % N
  }

  def main(args: Array[String]): Unit = {
    var line: String = null
    var arrs: Array[String] = null
    while ({
      line = readLine()
      line != null
    }) {
      arrs = line.split(" ")
      println(modExp(arrs(0).toInt, arrs(1).toInt, arrs(2).toInt))
    }
  }
}