import scala.actors.Actor

//EJ1
trait Loggable {
    def log(level: Int, message: String) =
        println("[level %d] %s".format(level, message))
}

class MyActor extends Actor with Loggable {
    def act = {
        log(level=5, "starting actor...")
    }
}

//EJ2
trait BetterLoggable extends Loggable {
    override def log(level: Int, message: String) =
        println("a better log message: " + message)
}

val actor = new MyActor with BetterLoggable
actor start
