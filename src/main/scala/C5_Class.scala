object C5_Class {

    class Counter {
        var value = 0
        private var privateAge = 0

        def increment() {
            value += 1
        }

        def current() = value

        def age = privateAge

        def age_=(newAge: Int) {
            if (newAge > privateAge) {
                privateAge = newAge
            }
        }
    }

    def main(args: Array[String]): Unit = {
        val myCounter = new Counter
        myCounter.increment()
        myCounter.increment()
        myCounter.increment()
        println(myCounter.current())
        println(myCounter.value)
        myCounter.value = 100
        println(myCounter.value)
        // 自定义GetterSetter
        println(myCounter.age)
        myCounter.age = 25
        println(myCounter.age)
    }
}