import java.util.Date
def log(now: Date)(msg: String) = println("[%s] %s".format(now, msg))

val logNow = log(new Date) _
logNow("hello")
logNow("world")
