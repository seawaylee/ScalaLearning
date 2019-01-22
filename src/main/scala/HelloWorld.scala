

object HelloWorld {
  def main(args: Array[String]): Unit = {
    //    for (i <- 1 to 3; j <- 1 to 4 if i != j) {
    //      println(i + "," + j)
    //    }

    //    val x = for (i <- 1 to 10) yield i % 3
    //    println(x)

    val arr = Array(1, 2, 3, 4, 5)
    //    for (data <- arr) {
    //      println(data)
    //    }
    for (i <- 0 until arr.length) {
      //      println(arr(i))
    }

    val result = for (elem <- arr) yield elem * 2
    for (elem <- result) {
//      println(elem)
    }
    val res1 = arr filter {
      _ % 2 == 0
    } map {
      2 * _
    }
    for (elem <- res1) {
      println(elem)
    }
  }

}
