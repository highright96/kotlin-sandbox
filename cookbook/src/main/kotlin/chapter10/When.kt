package chapter10

fun main() {
    printMod3(10)
    printMod3SingleStatement(10)
}

fun printMod3(n: Int) {
    when (n % 3) {
        0 -> println("0")
        1 -> println("1")
        2 -> println("2")
    }
}

fun printMod3SingleStatement(n: Int) = when (n % 3) {
    0 -> println("0")
    1 -> println("1")
    2 -> println("2")
    else -> println("exception")
}

val <T> T.exhaustive: T
    get() = this

fun printMod3WithExhaustive(n: Int) {
    when (n % 3) {
        0 -> println("0")
        1 -> println("1")
        2 -> println("2")
        else -> println("exception")
    }.exhaustive
}