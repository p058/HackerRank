/**
  * Created by pdannamaneni on 11/30/16.
  */

object Solution {


  def main(args : Array[String]): Unit ={

    val numPlants = scala.io.StdIn.readLine().toInt

    val plants = scala.io.StdIn.readLine().split(" ").map(s => s.toInt)

    var st = new scala.collection.immutable.Stack[Int]

    var numDaysKill = new Array[Int](numPlants)

    var currDays = 0

    var maxDays = 0

    st = st.push(0)

    numDaysKill(0) = 0

    for(j <- Range(1, numPlants)){

      if(plants(j) > plants(j-1)){
        numDaysKill(j) = 1
      }

      while(st.length > 0  && plants(j) <= plants(st.top)){
        numDaysKill(j) = math.max(numDaysKill(j), numDaysKill(st.top)+1)
        st = st.pop
      }

      if(st.length<=0) {numDaysKill(j) = 0}


      if(numDaysKill(j) > maxDays){

        maxDays = numDaysKill(j)

      }

      st = st.push(j)

    }

     println(maxDays)

  }
}