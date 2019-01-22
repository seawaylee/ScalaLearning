import java.util.TimeZone

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object C3_ArrayLearning {
  /**
    * 1.编写一段代码，将a设置为一个n个随机整数的数组，要求随机数介于0 (包 含) 和n (不包含)之间。
    */
  def getRandomArray(n: Int): ArrayBuffer[Int] = {
    val arr = ArrayBuffer[Int]()
    for (i <- 0 until n) {
      arr += new Random().nextInt(n)
    }
    arr
  }

  /**
    * 2. 编写一个循环，将整数数组中相邻的元素置换。 例如， Array1， 2, 3, 4, 5)经过置换后变为Array (2, 1, 4, 3, 5) 。
    */
  def changeArrPosition(): Unit = {
    val sourceArr = ArrayBuffer[Int](1, 2, 3, 4, 5)
    print("source:" + sourceArr)
    for (i <- sourceArr.indices) {
      if (i % 2 != 0) {
        var temp = sourceArr(i - 1)
        sourceArr(i - 1) = sourceArr(i)
        sourceArr(i) = temp
      }
    }
    print("target:" + sourceArr)
  }

  /**
    * 3. 重复前一个练习，不过这一次生成一个新的值交换过的数组 。 使用 for/ yield。
    */
  def changeArrPostionWithNewArr(): Unit = {
    val sourceArr = ArrayBuffer[Int](1, 2, 3, 4, 5)
    print("source:" + sourceArr)
    val newArr = for (i <- sourceArr.indices) yield {
      if (i % 2 == 0 && i == sourceArr.length - 1) {
        sourceArr(i)
      } else if (i % 2 == 0 && i < sourceArr.length - 1) {
        sourceArr(i + 1)
      } else {
        sourceArr(i - 1)
      }
    }
    print("newArr:" + newArr)
  }

  /**
    * 4. 给定一个整数数组，产出 一个新的数组，包含元数组中的所有正值，以原有顺 序排列;之后的元素是所有零或负值，以原有顺序排列 。
    */
  def splitArrByZero(arr: Array[Int]): Array[Int] = {
    var newArrBuff = new ArrayBuffer[Int]()
    var gtZeroCursor = 0
    for (e <- arr) {
      if (e >= 0) {
        newArrBuff.insert(gtZeroCursor, e)
        gtZeroCursor += 1
      } else {
        newArrBuff.append(e)
      }
    }
    newArrBuff.toArray
  }

  /**
    * 5. 如何计算Array[Double]的平均值?
    */
  def calcDoubleAvg(source: Array[Double]): Double = {
    val sum = source.sum
    sum / source.length
  }

  /**
    * 6. 如何重新组织Array [Int]的元素将它们以反序排列?对于ArrayBuffer[Int] 你又会怎么做呢?
    */
  def reverseArr(source: Array[Int]): Array[Int] = {
    //    for (i <- 0 until source.length / 2) {
    //      var temp = source(i)
    //      source(i) = source(source.length - i - 1)
    //      source(source.length - i - 1) = temp
    //    }
    var sourceBuffer = source.toBuffer
    sourceBuffer.reverse.toArray
  }

  /**
    * 获取美洲时区
    */
  def getUSATimeZone(): Array[String] = {
    var allTimeZone = TimeZone.getAvailableIDs
    allTimeZone = allTimeZone.filter(_.startsWith("America")).map(_.replace("America/", "")).sorted.take(5)
    allTimeZone
  }

  def main(args: Array[String]): Unit = {
    // print(splitArrByZero(Array[Int](5, 1, -1, 0, 2, -3, 9, -8, 10)).mkString(","))
    //    print(calcDoubleAvg(Array(1, 2, 3, 4, 5, 3.5)))
    //    print(reverseArr(Array(1, 2, 3, 4, 5, 6)).mkString(","))
    print(getUSATimeZone().mkString(","))
  }
}
