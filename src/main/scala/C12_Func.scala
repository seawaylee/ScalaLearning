import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object C12_Func {

    /**
      * 1. 编写函数values(fun: (Int) => Int, low: Int, high: Int)，该函数需 要交 出一个集合，对应给定区间内给定函数的输入和输出 。
      * 比如， values(x => x 女儿 ”5, 5)应该产出一个对偶的集合(-5, 25)' (-4, 16)' (-3,9),...,(5, 25)。
      */
    def values(func: Int => Int, low: Int, high: Int): mutable.ArrayBuffer[(Int, Int)] = {
        var resArray = new mutable.ArrayBuffer[(Int, Int)]()
        for (num <- low to high) {
            resArray.append((num, func(num)))
        }
        resArray
    }

    /**
      * 2. 如何用 reduceLeft得到数组中的最大元素?
      */
    def findMax(array: ArrayBuffer[Int]): Int = {
        var max = Integer.MIN_VALUE
        array.reduceLeft(math.max(_, _))
    }

    /**
      * 3. 用 to和 reduceLeft实现阶乘函数，不得使用循环或递归 。
      */
    def factorial(num: Int): Int = {
        (1 to num).reduceLeft(_ * _)
    }

    /**
      * 4. 前一个实现需要处理一个特殊情况， &Pn<I的情况。 展示如何用foldLeft来免
      * 除这个必要 。 (在Scaladoc中查找 foldLeft的说明 。
      * 它和 reduceLeft很像，只不过所有需要结合在一起的这些值的首值在调用的时候给出
      */
    def superFactorial(num: Int): Int = {
        (1 to num).foldLeft(1)(_ * _)
    }

    /**
      * 5. 编写函数largest(fun: (Int)=> Int, inputs : Seq口nt])，输出在给定 输入序列中给定函数的最大值。 举例来说， largest(x => 10 * x - x * x,
      * 1 to 10)应该返回25。 不得使用循环或递归。
      */
    def largest(fun: Int => Int, inputs: Seq[Int]): Int = {
        for (elem <- inputs) {
            println(elem, fun(elem))
        }
        val i = inputs.reduceLeft((a, b) => if (fun(a) > fun(b)) a else b)
        fun(i)
    }

    /**
      * 7  要得到一个序列的对偶很容易，比如:
      * val pairs = (1 to 10) zip (11 to 20)
      * 假定你想要对这个序列做某中操作—比如，给对偶中的值求和，但是你不能直接使用:
      * pairs.map(_ + _)
      * 函数_ + _ 接受两个Int作为参数，而不是(Int,Int)对偶。
      * 编写函数adjustToPair,该函数接受一个类型为(Int,Int)=>Int的 函数作为参数，并返回一个等效的, 可以以对偶作为参数的函数。
      * 举例来说就是:adjustToPair(_ * _)((6,7))应得到42。然后用这个函数通过map计算出各个对偶的元素之和
      */
    object TestTupleMulti {
        private var list = List[Int]()

        private def adjustToPair(fun: (Int, Int) => Int)(tup: (Int, Int)) = {
            list = fun(tup._1, tup._2) :: list
            this
        }

        def map(fun: (Int, Int) => Int): Int = {
            list.reduceLeft(fun)
        }

        def doTest(): Unit = {
            //val pairs = (1 to 10) zip (11 to 20)
            val pairs = (6 to 6) zip (7 to 7) // TODO What is this shit?
            for ((a, b) <- pairs) {
                adjustToPair(_ * _)((a, b))
            }
            println(map(_ + _))
        }
    }

    /**
      * 8. 在12.8节中，你看到了用于两组字符串数组的corresponds方法。
      * 做出一个对该方法的调用，让它帮我们判断某个字符串数组里的所有元素的长度是否和某个给定的整数数组相对应
      */
    def testStrLenEqual(): Unit = {
        val a = Array("asd", "df", "aadc")
        val b = Array(3, 2, 4)
        val c = Array(3, 2, 1)

        println(a.corresponds(b)(_.length == _))
    }

    /**
      * 10  实现一个unless控制抽象，工作机制类似if,但条件是反过来的。第一个参数需要是换名调用的参数吗？你需要柯里化吗？
      */
    object TestCondition {
        def unless(condition: => Boolean)(block: => Unit) = {
            if (!condition) {
                block
            }
        }

        def doTest(): Unit = {
            var x = 10
            unless(x == 0) {
                x -= 1
                println(x)
            }
        }
    }

    def main(args: Array[String]): Unit = {
        //println(values(x => x * x, -5, 5))
        //val arr = ArrayBuffer[Int](2, 5, 6, 21, 4324, 6547, 34, 54, 87567, 8, 45, 32, 6)
        //println(findMax(arr))
        //println(arr)
        //println(factorial(10))
        //println(superFactorial(-10))
        //println(largest(x => 10 * x - x * x, 1 to 10))
        //TestTupleMulti.doTest()
        //testStrLenEqual()
        TestCondition.doTest()
    }

    def test(): Unit = {
        // 函数作为值
        val arr = Array(3.14, 2.1, 1.9)
        val f: Double => Double = math.ceil
        //arr.map(f).foreach(println(_))

        // 函数作为函数的参数(高阶函数)
        def funParamsFun(f: Double => Double) = f(0.25)

        //println(funParamsFun(math.ceil))
        //println(funParamsFun(math.sqrt))

        def mulBy(factor: Double) = (x: Double) => factor * x

        //println(mulBy(3)(5))

        // 常用高阶函数
        Array(1, 2, 3, 4, 5).map(3 * _).foreach(println)
        val res = (1 to 9).reduceLeft(_ * _)
        //println(res)
        println("Niko Belic Is A Good Boy".split(" ").sortWith(_.length < _.length).mkString(" "))
    }

}
