import scala.actors.Actor._

val printer = actor {
    loop {
        receive {
            case v: Int => println("received " + v)
        }
    }
}

printer ! 4
