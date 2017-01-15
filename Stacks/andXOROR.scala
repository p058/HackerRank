/**
  * Created by pdannamaneni on 12/15/16.
  */

/**
 Ex: 9 , 8, 3, 5 , 7

  push index 0, st = [9]
  curr element - 8 < 9  ---cal XOR--> max  = max(0, 8^9) = 1 ---pop-> st = [] ( Since you know that 9 can atmost be the second smallest and you
  already calculated 8^9. So pop it) ---> st = [8]
  Similarly
  curr element - 3 < 8 ---cal XOR---> max= max(1,11) = 11 --pop-> st = [] ---> st=[3]
  curr element - 5 > 3 ---cal XOR(in else) --> max = max(11,6) = 11 ---> st = [3,5] (5 on top)
  curr element - 7 > 5 ---cal XOR(in else) --> max = max(11,2) = 11 ---> st = [3,5,7] (7 on top)

  max = 11
  **/



object Solution{

  def main(args : Array[String]) : Unit={

      val n = scala.io.StdIn.readLine().toInt

      val arr = scala.io.StdIn.readLine().split(" ").map(s => s.toInt)

      var st = new scala.collection.mutable.ArrayBuffer[Int] // I tried using stack in scala.collection.mutable.Stack, but it timed out on few test cases

      var max = 0

      st.append(0)

      for(i<-Range(1, n)) {

        var k = true // A boolean to break the loop. Wish there was a break keyword

        val current_elem = arr(i)

        while(st.length > 0 && k==true) {

          if (current_elem < arr(st(st.length - 1))) {

            max = math.max(max, arr(i) ^ arr(st(st.length - 1)))
            st.remove(st.length - 1)
          }

          else{
            k=false
            max = math.max(max, current_elem ^ arr(st(st.length - 1)))
          }
        }

        st.append(i)

      }

  println(max)

  }


}