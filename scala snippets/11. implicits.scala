// <código cerrado>
trait Callback {
    def onClick: Unit
}
class Button(val callback: Callback) {
    def click = callback onClick
}
// </codigo cerrado>

// definimos una clase que recibe un closure por parámetro
class ClosureCallback(val f: () => Unit) extends Callback {
override def onClick = f()
}

// una función mas, marcada para aplicación implícita
implicit def convertClosureToClosureCallback
(f: () => Unit) = new ClosureCallback(f)

// probemos :)
val b = new Button( () => println("hola") )
b click
