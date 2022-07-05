package inflearn.lec16

fun main() {
    val num = 3
    num.add1(10)

    num.add2(10)
    num add2 10
}

fun Int.add1(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}