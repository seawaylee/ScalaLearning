import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object C13_Collection {
    /**
      * 1. 编写一个函数 ， 给定字符串，产出 一个包含所有字符的下标的映射 。
      * 举例来 说， indexes (”M工ssiss工pp工”)应返回一个映射 ，让’M’对应集{ 0 }，’i’对应集 {l, 4, 7, 10)， 依此类推。 使用字符到可变集的映射。
      * 另外，你如何保证集是经过排序的?
      */
    def indexes(str: String): mutable.Map[Char, ArrayBuffer[Int]] = {
        var indexMap = new mutable.HashMap[Char, ArrayBuffer[Int]]()
        for (elem <- str.toCharArray.zipWithIndex) {
            if (!indexMap.contains(elem._1)) {
                indexMap(elem._1) = new ArrayBuffer[Int]()
            }
            indexMap(elem._1) += elem._2
        }
        indexMap
    }

    /**
      * 2. 重复前一个练习，这次用字符到列表的不可变映射。
      */
    def indexes2(str: String): Map[Char, ArrayBuffer[Int]] = {
        // TODO FUCK!
        null
    }

    /**
      * 3. 编写一个函数，从一个 ListBuffer中移除排在偶数位的元素 。 采用两种不同的
      * 方式 。 从列表尾端开始调用 remove (i)移除所有i为偶数的元素 。 将奇数位的元
      * 素复制到新的列表中。 比较这两种方式的性能表现。
      */
    def moveElems(dataList: ListBuffer[Int]): ListBuffer[Int] = {
        var index = 0
        val iterator = dataList.iterator
        while (iterator.hasNext) {
            if (index % 2 == 0) {
            }
        }
        null
    }

    /**
      * 4. 编写一个函数，接受一个字符串的集合，以及一个从字符串到整数值的映射 。
      * 返回整型 的集合 ，其值为能和集合中某个字符串相对应的映射的值 。
      * 举例来 说，给定Array(”Tom”, ”Fred”, ”Harry”)和Map(叮om" -> 3, ”Dick” -> 4,”Harry”-> 5)，返回Array(3, 5)。
      * 提示:用flatMap将get返回的 Option值组合在一起 。
      */
    def matchTest(names: Array[String], configMap: Map[String, Int]): Array[Int] = {
        names.flatMap(configMap.get(_))
        //var matchedData = new ArrayBuffer[Int]()
        //names.foreach(name => if (configMap.contains(name)) matchedData.append(configMap(name)))
        //matchedData
    }

    /**
      * 5. 实现一个函数，作用与 mkString丰目同，使用 reduceLeft。
      */
    def myMkString(arr: Array[Any], joinStr: String): String = {
        arr.reduceLeft(_.toString + joinStr + _.toString).toString
    }

    /**
      * 6. 给定整型列表1st, (1st :\ List口nt] ()) (_ :: _)得到什么? (List[Int]()
      * / : 1st) (_ : + _)又得到什么?如何修改它们中 的一个，以对原列表进行反向 排列?
      */
    def testList(): Unit = {
        var list = List(1, 2, 3, 4, 5)
        println((list :\ List[Int]()) (_ :: _))
        println((List[Int]() /: list) (_ :+ _))
        println((List[Int]() /: list) ((a, b) => b :: a))
    }

    /**
      * 7. 在13.10节中，表达式(prices zip quantities) map { p => p._1 * p.一2 } 有些不够优雅 。
      * 我们不能用( prices zip quantities ) map { _ * _ }，因 为-*-是一个带两个参数的函数，而我们需要的是一个带单个类型为元组的 参数的函数 。
      * Function对象的 tup1ed方法可以将带两个参数 的函数改为以元 组为参数 的函数 。 将 tup1ed应用于乘法函数 ，以便我们可以用它来映射由对偶 组成的列表。
      */
    def zipTest(): Unit = {
        var prices = Array(1.1, 2.2, 3.3)
        var quantities = Array(1, 2, 3)
        //println((prices zip quantities).map(p => p._1 * p._2).mkString(","))
        println((prices zip quantities).map(Function.tupled(_ * _)).mkString(","))
    }

    /**
      * 8. 编写一个函数，将Double数组转换成二维数组。 传人列数作为参数。
      * 举例 来说， Array(1, 2, 3, 4, 5, 6)和三列，返回Array(Array(1, 2, 3), Array(4, 5, 6))。 用grouped方法。
      */
    def makeGroup(arr: Array[Int], i: Int): Array[Array[Int]] = {
        arr.grouped(i).toArray
    }

    def main(args: Array[String]): Unit = {
        //println(indexes2("Mississippi"))
        //println(matchTest(Array[String]("Tom", "Fred", "Harry"),
        //    HashMap[String, Int]("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)).mkString(","))
        //println(myMkString(Array("1", "2", "3"), "_"))
        //testList()
        //zipTest()
        makeGroup(Array(1, 2, 3, 4, 5, 6), 3).foreach(arr => println(arr.mkString(",")))
    }


    def sum(lst: List[Int]): Int = {
        if (lst.isEmpty) 0 else lst.head + sum(lst.tail)
    }

    /*def main(args: Array[String]): Unit = {
        /*
        1. 向后(:+)或向前(+:)追加元素到序列 当中。
        2. 添加(+)元素到无先后次序的集合中。
        3. 用...操作符移除元素。
        4. 用++和一来批量添加或移除元素。
        5. 改值操作有+=、++=、-=和一=。
        6. 对于列表，许多 Scala程序员都优先选择::和:::操作符。
        7. 尽量别用++:、+=:和++= : 。
         */
        //val lst = List(1, 4, 6, 72, 2, 7, 21)
        //println(sum(lst))
        var l1 = List(1, 2, 3)
        var l2 = List(4, 5, 6)
        println("l1", l1)
        println("l2", l2)
        println("l1 +: l2", l1 +: l2)
        println("l1 +: l2", l1 +: l2)
        println("l1 ++ l2", l1 ++ l2)
        println("l1 :: l2", l1 :: l2)
        println("l1 ::: l2", l1 ::: l2)
        var s1 = Set(1, 2, 3)
        var s2 = Set(2, 3, 4)
        println("s1", s1)
        println("s2", s2)
        println("s1 union s2", s1 union s2)
        println("s1 & s2", s1 & s2)
        println("s1 ++ s2", s1 ++ s2)
        println("s1 -- s2", s1 -- s2)
        println("s1 ++= s2", s1 ++= s2, s1)
        var arr1 = ArrayBuffer(1, 2, 3)
        var arr2 = ArrayBuffer(2, 3, 4)
        println("arr1 ++=: arr2", arr1 ++=: arr2, arr1, arr2)

        println(for (i <- 1 to 10; j <- 1 to i) yield i * j)
        println((1 to 10).flatMap(i => (1 to i).map(j => i * j)))
        println(List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1))

        def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

        val squares = numsFrom(1).map(x => x * x)
        println(squares.take(5).force)
        for (i <- (0 until 100).par) print(s"$i,")
    }*/
}
