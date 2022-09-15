package chapter09

fun main() {
    val list1 = listOf(1, 2)
    printContents(list1)

    val list2 = mutableListOf(1, 2)
    //addAnswer(list2)
}

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Number>) {
    list.add(42)
}