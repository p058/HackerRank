/**
  * Created by pdannamaneni on 11/20/16.
  */

object Helper {

  def getHourGlassSum(tmp: Array[Array[Int]]): Int = {

    var s = 0

    s += tmp.head.sum

    s += tmp.last.sum

    val mid = tmp.length / 2

    s += tmp.slice(1, tmp.length - 1).map(s => s(mid)).sum

    s

  }
}

object Solution {


  def main(args : Array[String]): Unit ={

    val matrixSize = 6

    val hourGlassSize = 3

    if (hourGlassSize/2 == 0) throw new Exception("Pass an Odd Number")

    val arr = Array.ofDim[Int](matrixSize, matrixSize)

    for(i<-Range(0,matrixSize)){

      val str = scala.io.StdIn.readLine()

      arr(i) = str.split(' ').map(s=>s.toInt)

    }

    val maxIter = matrixSize - (hourGlassSize - 1)

    var maxHourGlassSum = 0

    for(j<-Range(0, maxIter); k<-Range(0, maxIter)){

      val tmp = arr.slice(j, j+hourGlassSize).map(s => s.slice(k, k+hourGlassSize))

      if (j == 0 && k == 0)

        maxHourGlassSum = Helper.getHourGlassSum(tmp)

      else {

        val s = Helper.getHourGlassSum(tmp)

        if (maxHourGlassSum < s) maxHourGlassSum = s

      }

    }

    println(maxHourGlassSum)

  }

}