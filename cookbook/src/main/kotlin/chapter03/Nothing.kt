package chapter03

fun main() {
    for(n in 1..10) {
        val x = when(n % 3) {
            0 -> "a"
            1 -> "b"
            2 -> "c"
            else -> throw Exception("error")
        }
    }
}