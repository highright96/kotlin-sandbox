package chapter09

fun main() {
    val unknownElement: MutableList<*> = mutableListOf<Int>()
    //unknownElement.add(1)

    val list: MutableList<Any?> = mutableListOf(1, "a")
    list.add(1)
    println(list)
}