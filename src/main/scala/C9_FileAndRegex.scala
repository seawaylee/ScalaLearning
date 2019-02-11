import java.io.{File, PrintWriter}

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.sys.process._

object C9_FileAndRegex {
    /**
      * 读文件
      */
    def readFile(fileName: String) = {
        val fileContentItor = Source.fromFile(fileName)
        for (elem <- fileContentItor.getLines()) {
            println(elem)
        }
        fileContentItor.close()
    }

    def writeFile(fileName: String) = {
        val writer = new PrintWriter(fileName)
        for (i <- 1 to 100) {
            writer.println(i)
        }
        writer.close()
    }

    def testRegex() = {
        //        val numberPattern = "[0-9]+".r
        //        val wordNumWordPattern = """\s+[0-9]+\s+""".r
        //        for (checkRes <- wordNumWordPattern.findAllIn("99 bottles , 98 bottles")) {
        //            println(checkRes)
        //        }

        val varPattern = """\$[0-9]+""".r

        def format(message: String, vars: String*) {
            print(varPattern.replaceSomeIn(message, m => vars.lift(m.matched.tail.toInt)))
        }

        format("At $1 , there was $2 on $0.,extra $4", "planet 7", "12:30 pm", "a disturbance of the force")
    }


    /**
      * 1  编写一小段Scala代码，将某个文件中的行倒转顺序(将最后一行作为第一行,依此类推)
      */
    def reverseFile(): Unit = {
        val fileName = "/Users/lixiwei-mac/Documents/IdeaProjects/scala-learning/testWrite.txt"
        val fileItor = Source.fromFile(fileName)
        val content = fileItor.getLines()
        val reversedContent = content.toArray.reverse
        val writer = new PrintWriter(fileName)
        reversedContent.foreach(data => writer.println(data))
        fileItor.close()
        writer.close()
    }

    /**
      * 3. 编写一小段Scalaf-1;'.:码，从一个文件读取内容并把所有字符数大于 12的单词打印
      * 到控制台。 如果你能用单行代码完成会有额外奖励。
      */
    def findLongWordsFromFile(fileName: String) = {
        Source.fromFile(fileName).getLines()
          .foreach(line => line.split("\\s+").toBuffer
            .filter(word => word.length > 12)
            .foreach(word => println(word.length + ":" + word.mkString)))
    }

    /**
      * 4  编写Scala程序，从包含浮点数的文本文件读取内容，打印出文件中所有浮点数之和，平均值，最大值和最小值
      */
    def sumFloat(fileName: String) = {
        var total = 0d
        //        var count = 0
        //        var max = Double.MinValue
        //        var min = Double.MaxValue
        //        Source.fromFile(fileName).mkString.split("\\s+").filter(word => word.matches("""[0-9]+.?[0-9]*""")).foreach(word => {
        //            total += word.toDouble
        //            count += 1
        //            if (word.toDouble > max) max = word.toDouble
        //            if (word.toDouble < min) min = word.toDouble
        //        })
        var doubleWords = Source.fromFile(fileName).mkString.split("\\s+").filter(_.matches("""[0-9]+.?[0-9]*""")).map(_.toDouble)
        println("total:", doubleWords.sum, "avg:", doubleWords.sum / doubleWords.length, "min", doubleWords.min, "max", doubleWords.max)
    }


    def main(args: Array[String]): Unit = {
        //readFile("/Users/lixiwei-mac/Documents/IdeaProjects/scala-learning/build.sbt")
        //writeFile("/Users/lixiwei-mac/Documents/IdeaProjects/scala-learning/testWrite.txt")
        //val value = "ls -l".!!
        //println(value)
        //        ("ls -l" #| "grep b").!
        //        ("ls -l " #> new File("fileList.txt")).!
        //        val dirName = "/Users/lixiwei-mac/Documents/IdeaProjects/scala-learning/src/test"
        //        val cmd = "ls -l"
        //        val p = Process(cmd, new File(dirName), ("LANG", "en_US"))
        //        ("echo 42" #| p).!
        //        findLongWordsFromFile("/Users/lixiwei-mac/Documents/IdeaProjects/scala-learning/src/main/scala/C4_HashAndTuple.scala")
        //        reverseFile()
        sumFloat("/Users/lixiwei-mac/Documents/IdeaProjects/scala-learning/testWrite.txt")

    }
}
