class Math {
    def divideBy(a: Int, b: Int) =
        if (b == 0) throw new IllegalArgumentException
        else a / b
}
