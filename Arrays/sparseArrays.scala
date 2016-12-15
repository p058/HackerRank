/**
  * Created by pdannamaneni on 11/22/16.
  */

object Solution {

  def main(args: Array[String]): Unit = {

    val N = scala.io.StdIn.readLine().toInt

    val M: Map[String, Int] = Map()

    var counts = mutable.Map.empty[String, Int]

    for (i <- Range(0, N)) {

      val tmp = scala.io.StdIn.readLine()

      val word = tmp.toLowerCase

      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0

      counts = counts + (word -> (oldCount + 1))

    }

    val Q = scala.io.StdIn.readLine().toInt

    for(j<- Range(0, Q)){

      val tmp = scala.io.StdIn.readLine()
      val word = tmp.toLowerCase
      val newCount =
        if (counts.contains(word)) counts(word)
        else 0
      println(newCount)
    }
  }
}

