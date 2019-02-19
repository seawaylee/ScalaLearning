import java.awt.Point
import java.awt.geom.Ellipse2D

object C10_Trait {

    /**
      * 1. java. awt. Rectangle类有两个很有用的方法translate和grow，但可情的是 像java. awt .geom.Ellipse2D这样的类中没有。 在Scala中，你可以解决这个
      * 问题 。 定义一个 RectangleLike特质，加入具体的 translate和 grow方法 。 提供任何你需要用来实现的抽象方法，以便你可以像如下代码这样混入该特 质:
      * val egg= new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) w工th RectangleLike
      * egg .translate(lO, -10)
      * egg .grow(lO, 20)
      */
    trait RectangleLike {
        this: Ellipse2D.Double =>
        def translate(x: Int, y: Int): Unit = {
            this.x = x
            this.y = y
        }

        def grow(x: Int, y: Int): Unit = {
            this.x += x
            this.y += y
        }
    }

    //def main(args: Array[String]): Unit = {
    //    val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    //    egg.translate(10, -10)
    //    println("x:", egg.getX, "y:", egg.getY)
    //    egg.grow(10, 20)
    //    println("x:", egg.getX, "y:", egg.getY)
    //}

    /**
      * 2. 通过把scala.math.Ordered[Point]混入〕ava.awt.Point的方式，定义 OrderedPoint类 。
      * 按词典顺序排序，也就是说，如果 x<x’或者 x=x’且y <y’ 则 (x, y ) < ( x ' , y ')。
      */
    class OrderedPoint extends Point with Ordered[Point] {
        override def compare(that: Point): Int = {
            if (this.x <= that.x && this.y < that.y) {
                -1
            } else if (this.x == that.y && this.y == that.y) {
                0
            } else {
                1
            }
        }
    }

    //def main(args: Array[String]): Unit = {
    //    /*
    //    （1）sorted
    //    对一个集合进行自然排序，通过传递隐式的Ordering
    //    （2）sortBy
    //    对一个属性或多个属性进行排序，通过它的类型。
    //    （3）sortWith
    //    基于函数的排序，通过一个comparator函数，实现自定义排序的逻辑。
    //     */
    //    val op1 = new OrderedPoint()
    //    op1.setLocation(3, 4)
    //    val op2 = new OrderedPoint()
    //    op2.setLocation(4, 5)
    //    val op3 = new OrderedPoint()
    //    op3.setLocation(1, 2)
    //    val opArr = Array(op1, op2, op3)
    //    opArr.sortWith(_.compare(_) < 0).foreach(println)
    //}

    /**
      * 多层继承
      */
    trait Fly {
        def fly(): Unit = {
            println("flying...")
        }

        def flyWithSinging()
    }

    trait Walk {
        def walk(): Unit = {
            println("walking...")
        }
    }

    class Bird extends Fly with Walk {
        def flyWithSinging(): Unit = {
            println("fly with singing...")
        }
    }
    def main(args: Array[String]): Unit = {
        val bird = new Bird()
        bird.fly()
        bird.walk()
        bird.flyWithSinging()

    }

    //def main(args: Array[String]): Unit = {
    //
    //}
}
