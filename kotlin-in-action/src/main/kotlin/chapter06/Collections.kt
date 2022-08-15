package chapter06

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for(item in source) {
        target.add(item)
    }
}

fun main() {
    val l = listOf(1, 2)
    val m = mutableListOf<Int>()
    copyElements(l, m)
    println(l)
    println(m)
}