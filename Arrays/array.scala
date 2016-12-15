import scala.io.StdIn

//import scala.io.StdIn.readLine

/**
  * Created by pdannamaneni on 11/20/16.
  */

object Solution {

    def main(args : Array[String]) : Unit= {

        val n = scala.io.StdIn.readInt()
        val st = scala.io.StdIn.readLine()
        val li = st.split(' ').map(s => s.toInt)

        println(li.reverse.mkString(" "))
    }
}
