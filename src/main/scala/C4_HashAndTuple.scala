import java.util
import java.util.Calendar

import scala.collection.mutable.ArrayBuffer
import scala.collection.{JavaConverters, immutable, mutable}

object C4_HashAndTuple {
    /**
      * 1. 设置一个映射，其中包含你想要的一些装备及其价格。 然后构建另一个映射， 采用同一组键，但在价格上打9折。
      */
    def getDisCountMap(prodMap: Map[String, Double], discount: Int): Map[String, Double] = {
        var discountMap = Map[String, Double]()
        println("source", prodMap)
        //        for ((k, v) <- prodMap) yield (k, v * (discount / 10.0))
        for ((k, v) <- prodMap) {
            discountMap += (k -> v * (discount / 10.0))
        }
        return discountMap
    }

    /**
      * 2. 编写一段程序，从文件中读取单词。用一个可变映射来清点每一个单词出现的频率
      */
    def getWordFreqMapV1(filePath: String): ArrayBuffer[Seq[Any]] = {
        var wordMap = mutable.ListMap[String, Integer]()
        val in = new java.util.Scanner(new java.io.File(filePath))
        while (in.hasNext()) {
            val wordArr: Array[String] = in.next().split(" ")
            for (word <- wordArr) {
                wordMap += (word -> (1 + Integer.valueOf(wordMap.getOrElse(word, 0).toString)))
            }
        }
        ArrayBuffer(wordMap.toSeq.sortBy(_._2).reverse)
    }

    /**
      * 3. 重复前一个练习，这次用不可变的映射。
      */
    def getWordFreqMapV2(filePath: String): ArrayBuffer[Seq[Any]] = {
        var wordMap = immutable.ListMap[String, Integer]()
        val in = new java.util.Scanner(new java.io.File(filePath))
        while (in.hasNext()) {
            val wordArr: Array[String] = in.next().split(" ")
            for (word <- wordArr) {
                wordMap += (word -> (1 + Integer.valueOf(wordMap.getOrElse(word, 0).toString)))
            }
        }
        ArrayBuffer(wordMap.toSeq.sortBy(_._2).reverse)
    }

    /**
      * 4. 重复前一个练习，这次用已排序的映射，以便单词可以按顺序打印出来。
      */
    def getWordFreqMapV3(filePath: String): ArrayBuffer[Seq[Any]] = {
        var wordMap = mutable.SortedMap[String, Integer]()
        val in = new java.util.Scanner(new java.io.File(filePath))
        while (in.hasNext()) {
            val wordArr: Array[String] = in.next().split(" ")
            for (word <- wordArr) {
                wordMap += (word -> (1 + Integer.valueOf(wordMap.getOrElse(word, 0).toString)))
            }
        }
        ArrayBuffer(wordMap.toSeq.sortBy(_._2).reverse)
    }

    /**
      * 5. 重 复前一个练习，这次用 java . util . TreeMap并使之适用于 ScalaAPI。
      */
    def getWordFreqMapV4(filePath: String): ArrayBuffer[Seq[Any]] = {
        var wordMap = new util.TreeMap[String, Integer]()
        val in = new java.util.Scanner(new java.io.File(filePath))
        while (in.hasNext()) {
            val wordArr: Array[String] = in.next().split(" ")
            for (word <- wordArr) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1)
            }
        }
        ArrayBuffer(JavaConverters.mapAsScalaMap(wordMap).toSeq.sortBy(_._2).reverse)
    }

    /**
      * 6. 定义一个链式啥希映射，将” Monday”映射至Ujava .util .Calendar.MONDAY,
      * 依此类推加入其他日期。 展示元素是以插入的顺序被访问的。
      */
    def getWeekDayMap(): mutable.ListMap[String, Int] = {
        var calendarMap = mutable.ListMap[String, Int]("星期1" -> 0, "星期2" -> 0, "星期3" -> 0, "星期4" -> 0, "星期5" -> 0)
        var calendar = Calendar.getInstance()
        for (weekDay <- 1 to 7) {
            println(calendar.get(Calendar.DAY_OF_WEEK))
            calendar.add(Calendar.DAY_OF_WEEK, 1)
        }
        calendarMap
    }

    /**
      * 7. 打印出所有 Java系统属性的表格， 类似于下面这样:
      */
    def printSystemProps(): Unit = {
        val properties = System.getProperties()
        var propMap = mutable.ListMap[String, String]()
        val propNames = properties.propertyNames()
        while (propNames.hasMoreElements) {
            val nameValue = propNames.nextElement()
            propMap += (nameValue.toString -> properties.get(nameValue).toString)
        }
        propMap.toSeq.sortBy(_._2.length).reverse
        for (ele <- propMap) {
            println(ele._1, "\t", ele._2)
        }
    }

    /**
      * 8. 编 写一个函数 minmax(values: Array[Int])，返回数组中最小值和最大值的
      * 对偶。
      */
    def minmax(values: Array[Int]): mutable.Map[String, Int] = {
        var res = mutable.Map[String, Int]()
        for (elem <- values) {
            if (elem > res.getOrElse("max", Int.MinValue)) {
                res("max") = elem
            }
            if (elem < res.getOrElse("min", Int.MaxValue)) {
                res("min") = elem
            }
        }
        res
    }

    /**
      *  9. 编写一个函数 lteqgt(values : A rray[Int], v : Int)，返回数组中小于v、 等于v和大于V的数量，要求三个值一起返回 。
      */
    def calcNumber(values: Array[Int], checkValue: Int): mutable.Map[String, Int] = {
        val countMap = mutable.Map[String, Int]()
        for (elem <- values) {
            if (elem > checkValue) {
                countMap("gt") = countMap.getOrElse("gt", 0) + 1
            } else if (elem < checkValue) {
                countMap("lt") = countMap.getOrElse("lt", 0) + 1
            } else {
                countMap("eq") = countMap.getOrElse("eq", 0) + 1
            }
        }
        countMap
    }

    /**
      * 10. 当你将两个字符串拉链在一起时，比如 ”Hello'’ . zip (”World”) ， 会是什么结 果?想出一个讲得通的用例 。
      */
    def zipStrs(s1: String, s2: String): Any = {
        s1.zip(s2)
    }


    def main(args: Array[String]): Unit = {
        print(zipStrs("Hello", "World"))
    }
}
