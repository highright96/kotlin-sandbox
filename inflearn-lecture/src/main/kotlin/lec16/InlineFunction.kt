package lec16

fun main() {
    3.add(4)
}

inline fun Int.add(other: Int): Int {
    return this + other
}