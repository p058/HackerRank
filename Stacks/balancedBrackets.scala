/**
  * Created by pdannamaneni on 11/23/16.
  */

import scala.util.control._


object Solution {

  def main(args : Array[String]):Unit = {

    val openingbrackets = Array('{','(','[')

    val openclosemapper : Map[Char, Char] = Map('}'->'{', ')'->'(',']'->'[')

    val N = scala.io.StdIn.readLine().toInt

    for(i<-Range(0, N)) {

      var st = new scala.collection.immutable.Stack[Char]

      val query = scala.io.StdIn.readLine()

      var res = "YES"

      val loop = new Breaks

      loop.breakable {

        for (ch <- query) {

          if (openingbrackets.contains(ch)) st = st.push(ch)

          else {

            if (st.length > 0) {

              val ch_cl = st.top

              st = st.pop

              if (openclosemapper(ch) != ch_cl) {

                res = "NO"

                loop.break

              }
            }

            else {

              res = "NO"
              loop.break

            }

          }

        }

      }
      if(st.length == 0)
        println(res)
      else
        println("NO")
    }
  }
}