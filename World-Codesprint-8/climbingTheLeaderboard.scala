/**
  * Created by pdannamaneni on 12/17/16.
  */


object Helper {


  def getRanks(scores: Array[Int]) : Array[Int] = {

    var ranks = new Array[Int](scores.length)

    ranks(0) = 1

    for (k <- Range(1, scores.length)) {

      if (scores(k) == scores(k - 1)) {

        ranks(k) = ranks(k - 1)

      }

      else {

        ranks(k) = ranks(k - 1) + 1

      }

    }

    return ranks

  }


  def getRank(x: Int, ranks: Array[Int], arr: Array[Int], high : Int, low : Int) : Int = {

//    println(low, high, arr.mkString("|"))

    val mid = (low+high)/2

    if (x == arr(mid)) {return ranks(mid)}

    else if (x < arr(mid) && x > arr(mid+1)) {return ranks(mid)+1}

    else if (x < arr(mid - 1) && x > arr(mid)) {return  ranks(mid-1)+1}

    else if (x <= arr(high) && x >= arr(mid-1)) {return getRank(x, ranks, arr, high, mid)}

    else if (x <= arr(mid+1) && x >= arr(low)){return  getRank(x, ranks, arr, mid+1, low)}

    else if (x < arr(low)) {return ranks(low)+1}

    else {return 1}

  }
}

object Solution{

  def main(args : Array[String]): Unit={

    val num = scala.io.StdIn.readLine().toInt

    val scores = scala.io.StdIn.readLine().split(" ").map(s => s.toInt)

    val numLevels = scala.io.StdIn.readLine().toInt

    val levelScores = scala.io.StdIn.readLine().split(" ").map(s => s.toInt)

    val ranks = Helper.getRanks(scores)

//    println(ranks.mkString("|"))

    for(j <- Range(0, numLevels)){

      val rank  = Helper.getRank(levelScores(j), ranks, scores, 0, scores.length-1)

      println(rank)

    }

  }


}