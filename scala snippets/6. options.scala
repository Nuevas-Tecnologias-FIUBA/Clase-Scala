def nullSafe(message: String) = if (message != null) Some(message) else None

nullSafe(null).foreach { e => println(e) }

nullSafe("hello").foreach { e => println(e) }

nullSafe(null).getOrElse("no value")

def sanitize(name: Option[String]) = name.map{ _.trim }.filter{_.length>0}.map{ _.toUpperCase }
