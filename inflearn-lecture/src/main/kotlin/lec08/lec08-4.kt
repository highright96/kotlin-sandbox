package lec08

fun main() {
    printAll("A", "B", "C")

    val arr = arrayOf("A", "B", "C")
    printAll(*arr)
}

fun printAll(vararg strings: String) {
    for(str in strings) {
        println(str)
    }
}