package chapter05

fun main() {
    val range = 3..8
    val num1 = 5.coerceIn(range)
    println(num1)

    val num2 = 1.coerceIn(range) //최소값 리턴
    println(num2)
}