object C6_Object {

    /**
      * 1. 编写一个Conversions对象，加入inchesToCentimeters、 gallonsToLiters和 milesToKilometers方法。
      */
    object Conversions {
        def inchesToCentimeters(inches: Int) = {
            println("inchesToCentimeters", inches)
        }

        def main(args: Array[String]): Unit = {
            inchesToCentimeters(100)
        }
    }

    /**
      * 2. 前 一个练习不是很面 向对 象。提供一个通用的超类 UnitConvers ion
      * 并定义扩展该超类的 InchesToCentimeters 、 GallonsToLiters和
      * MilesToKilometers对象。
      */
    class UnitConversion {
        var meter = 0
    }

    class InchesToCentimeters extends UnitConversion {

    }

    /**
      * 3. 定义一个扩展自 java . awt.Point的Origin对象 。 为什么说这实际上不是一个
      * 好主意?(仔细看Po工nt类的方法。 )
      */
    object SubPoint extends java.awt.Point {

    }

    /**
      * 4. 定义一个Point类和一个伴生对象，使得我们可以不用new而直接用Point(3,
      * 的来构造 Point实例 。
      */
    class Point(val x: Int, val y: Int) {
    }

    object Point {
        def apply(x: Int, y: Int) = new Point(x, y)
    }

    /**
      * 5. 编写一个Scala应用程序，使用App特质，以反序打印命令行参数，用空格隔
      * 开 。 举例来说， scala Reverse Hello World应该打印出 World Hello。
      */
    class MyStartApp extends App {
        println(args.reverse.mkString(" "))
    }

    /**
      * 6. 编写一个扑克牌四种花色的枚举，让其toString方法分别返回♣️，♦️，♥️，♠️。
      */
    object PlayingCardEnum extends Enumeration {
        val MEI_HUA = Value("♣")
        val FANG_PIAN = Value("♦")
        val HONG_TAO = Value("♥")
        val HEI_TAO = Value("♠")
    }

    /**
      * 7. 实现一个函数，检查某张牌的花色是否为红色 。
      */
    def checkCardType(card: String, checkTarget: PlayingCardEnum.Value): Boolean = {
        checkTarget.toString.equals(card)
    }

    /**
      * 8. 编写一个枚举，描述RGB立方体的八个角 。 ID使用颜色值(例如，红色 /Red是
      * OxffOOOO ) 。
      */
    object CubeEnum extends Enumeration {
        val CORNER_1 = Value("OxffOOOO")
        val CORNER_2 = Value("OxffOOO1")
        val CORNER_3 = Value("OxffOOO2")
        val CORNER_4 = Value("OxffOOO3")
        val CORNER_5 = Value("OxffOOO4")
        val CORNER_6 = Value("OxffOOO5")
        val CORNER_7 = Value("OxffOOO6")
        val CORNER_8 = Value("OxffOOO7")
    }

    def main(args: Array[String]): Unit = {
        //        val p = Point(3, 4)
        //        val myAPp = new MyStartApp()
        println(args.reverse.mkString(" "))

        //        for (cardType <- PlayingCardEnum.values) {
        //            println(cardType)
        //        }
        //        println(checkCardType("♠", PlayingCardEnum.HEI_TAO))

    }
}

