
class Complex(val real: Int, val imaginary: Int) {
    def +(o: Complex) = new Complex(real + o.real, imaginary + o.imaginary)

    override def toString() = 
        real + (if (imaginary < 0) "" else "+" ) + imaginary + "i"
}


val a = new Complex(3,4)
val b = new Complex(4,5)
a + b // igual a.+(b)
