package chapter02

import chapter02.Color.*

fun main() {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}

// 2.3.1
enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    BLUE(255, 10, 20)
}

// 2.3.2
fun getMnemonic(color: Color) =
    when (color) {
        RED, BLUE -> "Richard"
        ORANGE -> "Of"
    }

// 2.3.3
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, BLUE) -> ORANGE
        setOf(RED, ORANGE) -> BLUE
        else -> throw Exception()
    }

// 2.3.5
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if(e is Num) {
        val n = e as Num // 스마트 캐스팅 -> as Num 필요없음
        return n.value
    }
    if(e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException()
}

fun evalWhen(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> evalWhen(e.right) + evalWhen(e.left)
        else -> throw IllegalArgumentException()
    }