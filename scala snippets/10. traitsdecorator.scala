class Window{
    def draw = "ventana"
}

trait WBorder extends Window{
    override def draw = super.draw + " con borde"
}

trait WTitleBar extends Window{
    override def draw = super.draw + " con barra de titulo"
}

trait WMenuBar extends Window{
    override def draw = super.draw + " com barra de menu"
}

val w1 = new Window with WBorder with MenuBar
w1 draw // ventana con borde con barra de menu

val w2 = new Window with WTitleBar with WMenuBar with WBorder
w2 draw // ventana con barra de titulo con barra de menu con borde
