object Solution{

  def main(args: Array[String]): Unit = {

    val nd = scala.io.StdIn.readLine()

    val nd_l = nd.split(' ')

    val n  = nd_l(0).toInt

    val d = nd_l(1).toInt

    var arr = scala.io.StdIn.readLine()

    var arr2 = arr.split(" ").map(s=>s.toInt)

    var res=Solution.shift(arr2,d)

    print(res.mkString(" "))

  }




  def shift(arr: Array[Int], d: Int)={

    val r = new Array[Int](d)

    for(i<-Range(0, d)){

      r(i) = arr(i)
    }

    for(k<-Range(0, arr.length-d)){

      arr(k) = arr(k + d)

    }
    for(j<-Range(arr.length-d, arr.length)){

      arr(j) = r(j+d-arr.length)
    }
    arr
  }
}