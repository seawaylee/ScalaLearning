
object C11_Operator {

    /**
      * 3. 实现Fraction类，支持+ - * /操作。 支持约分，例如将15/-6变成-5/2
      */
    class Fraction(n: Int, d: Int) {
        private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
        private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

        override def toString = num + "/" + den

        def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

        def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

        def +(other: Fraction): Fraction = {
            newFrac((this.num * other.den) + (other.num * this.den), this.den * other.den)
        }

        def -(other: Fraction): Fraction = {
            newFrac((this.num * other.den) - (other.num * this.den), this.den * other.den)
        }

        def *(other: Fraction): Fraction = {
            newFrac(this.num * other.num, this.den * other.den)
        }

        def /(other: Fraction): Fraction = {
            newFrac(this.num * other.den, this.den * other.num)
        }

        private def newFrac(a: Int, b: Int): Fraction = {
            val x: Int = if (b == 0) 1 else a * sign(b) / gcd(a, b);
            val y: Int = if (b == 0) 0 else b * sign(b) / gcd(a, b);
            new Fraction(x, y)
        }
    }

    //def main(args: Array[String]): Unit = {
    //    val f1 = new Fraction(15, -6)
    //    val f2 = new Fraction(20, 60)
    //    println(f1)
    //    println(f2)
    //    println(f1 + f2)
    //    println(f1 - f2)
    //    println(f1 * f2)
    //    println(f1 / f2)
    //}

    /**
      * 4. 实现一个Money类,加入美元和美分字段。
      * 提供+,-操作符以及比较操作符==和<。
      * 举例来说，Money(1,75)+Money(0,50)==Money(2,25)
      */
    class Money(y: Int, f: Int) {
        private var yuan = y
        private var fen = f

        override def toString: String = yuan + "." + fen

        def +(other: Money): Money = {
            var totalYuan = this.yuan + other.yuan
            var totalFen = this.fen + other.fen
            if (totalFen >= 100) {
                totalYuan += 1
                totalFen -= 100
            }
            new Money(totalYuan, totalFen)
        }

        def -(other: Money): Money = {
            var totalYuan = this.yuan - other.yuan
            var totalFen = this.fen - other.fen
            if (totalFen < 0) {
                totalYuan -= 1
                totalFen += 100
            }
            new Money(totalYuan, totalFen)
        }
    }

    def main(args: Array[String]): Unit = {
        //val m1 = new Money(1, 75)
        //val m2 = new Money(3, 50)
        //println(m1, m2, m1 + m2, m1 - m2)
    }


}
