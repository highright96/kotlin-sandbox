package chapter09

fun main() {
    val letters = ('a'..'z').toList()
    letters.slice(10..13)

    val authors = listOf("a", "b")
    val readers = listOf("c", "d")

    authors.filter { it !in readers }
}

val <T> List<T>.penultimate: T
    get() = this[size - 1]

//val <T> x: T = TODO()