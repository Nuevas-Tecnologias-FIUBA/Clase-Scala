import scala.actors.Actor._

case class Sum(val left: Int, val right: Int)
case class Product(val left: Int, val right: Int)

val mathematician = actor {
  loop {
    receive {
      case Sum(left, right) => reply(left+right)
      case Product(left, right) => { 
          Thread.sleep(5000)
          println("setting")
          reply(left*right)}
      }
  }
}

mathematician ! Sum(3,4)
mathematician !! Product(3,4)
