/**
  * Created by pdannamaneni on 11/25/16.
  */

/*

1) Calculate the maximum area of rectange formed by adjacent bars in a histogram
    -- divide and conquer
       Find the minimum height of bar in the histogram and the maximum area should be one of the three a) to the
       left of the minimum b) to the right of the minimum c) minimum bar * number of bars
        Analysis:


 */


object Solution{


  def main(args : Array[String]) = {

    val N = scala.io.StdIn.readLine().toInt

    val builds = scala.io.StdIn.readLine().split(" ").map(s => s.toInt)

    val res = getMaxArea(builds)

    println(res)
  }

  def getMaxArea(xs : Array[Int]) : Int = {

    if(xs.length == 0)
      return 0

    else
    {

      val min_val = xs.min

      val min_index = xs.indexOf(min_val)

      val area_min = min_val * xs.length

      val area_right = getMaxArea(xs.slice(min_index + 1, xs.length))

      val area_left = getMaxArea(xs.slice(0, min_index))

      return Array(area_left, area_min, area_right).max

    }
  }

}