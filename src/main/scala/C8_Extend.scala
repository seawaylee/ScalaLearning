import scala.collection.mutable.ArrayBuffer

object C8_Extend {


    /**
      * 1. 扩展如下的 BankAccount类，新类 CheckingAccount对每次存款 和取款都收取1美元的手续费 。
      */
    class BankAccount(initBalance: Double) {
        protected var balance = initBalance

        def currBalance = balance

        def deposit(amount: Double) = {
            balance += amount
            balance
        }

        def withdraw(amount: Double) = {
            balance -= amount
            balance
        }
    }


    class CheckingAccount(initBalance: Double) extends BankAccount(initBalance) {
        private val TRAING_SERVICE_CHARGE = 1D

        override def deposit(amount: Double): Double = {
            super.deposit(amount - TRAING_SERVICE_CHARGE)
        }

        override def withdraw(amount: Double): Double = {
            super.withdraw(amount + TRAING_SERVICE_CHARGE)
        }
    }

    /**
      * 2. 扩展前一个练习的BankAccount类,新类SavingsAccount每个月都有利息产 生( earnMonthlylnterest方法被调用)，并且有每月 三次免手续费的存款或 取款 。 在 earnMonthlyinterest方法中重置交易计数 。
      */
    class SavingAccount(initBalance: Double) extends BankAccount(initBalance) {
        private var tradingTimesCurrMonth = 0
        private val INTEREST_PERCENT_MONTHLY = 0.01D
        private val TRAING_SERVICE_CHARGE = 1D

        def earnMonthlyInterest = {
            this.balance += this.balance * INTEREST_PERCENT_MONTHLY
            this.tradingTimesCurrMonth = 0
        }

        override def deposit(amount: Double): Double = {
            this.tradingTimesCurrMonth += 1
            super.deposit(amount)
            if (this.tradingTimesCurrMonth > 3) {
                this.balance -= TRAING_SERVICE_CHARGE
            }
            this.balance
        }

        override def withdraw(amount: Double): Double = {
            this.tradingTimesCurrMonth += 1
            super.withdraw(amount)
            if (this.tradingTimesCurrMonth > 3) {
                this.balance -= TRAING_SERVICE_CHARGE
            }
            this.balance
        }
    }

    /**
      * 4. 定义一个抽象类 Item， 加入方法price和description。 SimpleItem是一个在 构造器中给出价格和描述的物件 。
      * 利用 val可以 重写 def这个事实 。 Bundle是一 个可以包含其他物件的物件 。 其价格是打包中所有物件的价格之和 。
      * 同时提供 一个将物件添加到打包中的机制，以及一个合适的 description方法 。
      */
    abstract class Item {
        def price(): Double

        def description(): String

        override def toString: String = {
            "description:" + description() + "   price:" + price()
        }
    }

    class SimpleItem(val price: Double, val description: String) extends Item {

    }

    class Bundle extends Item {
        val items = new ArrayBuffer[Item]()

        def addItem(item: Item): Unit = {
            this.items += item
        }

        override def price(): Double = {
            var total = 0d
            items.foreach(total += _.price())
            total
        }

        override def description(): String = {
            items.mkString(",")
        }
    }

    /**
      * 5. 设计一个 Point类，其x和y坐标可以通过构造器提供 。 提供一个子类 LabeledPoint，其构造器接受一个标签值和x、 y坐标，比如:
      * new LabeledPoint (” Black Thursday", 1929, 230.07)
      */

    class Point(x: Double, y: Double) {

    }

    class LabeledPoint(val labelName: String, val x: Double, val y: Double) extends Point(x, y) {

        override def toString = s"LabeledPoint($labelName, $x, $y)"
    }

    /**
      * 6. 定义一个抽象类Shape、一个抽象方法centerPoint，以及该抽象类的子类 Rectangle和 Circle。 为子类提供合适的构造器，并重写 centerPoint方法 。
      */
    abstract class Shape {
        def centerPoint(): String
    }

    class Rectangle(x: Double, y: Double) extends Shape {
        override def centerPoint(): String = {
            s"($x,$y)"
        }

        override def toString = s"Rectangle($centerPoint)"
    }

    class Circle(x: Double, y: Double) extends Shape {
        override def centerPoint(): String = {
            s"($x,$y)"
        }

        override def toString: String = super.toString
    }

    def main(args: Array[String]): Unit = {
        println(new Rectangle(3.0, 4.0))
    }

}

