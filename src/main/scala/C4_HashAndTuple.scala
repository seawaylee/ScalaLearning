object C4_HashAndTuple {
    def main(args: Array[String]): Unit = {
        val hash = Map[String, Int]("Hello" -> 3, "World" -> 4)
        for ((k, v) <- hash) {
            print(k, v)
        }
    }
}
