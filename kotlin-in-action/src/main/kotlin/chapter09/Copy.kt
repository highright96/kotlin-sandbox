package chapter09

fun <T> copyData1(source: MutableList<T>, destination: MutableList<T>) {
    for(item in source) {
        destination.add(item)
    }
}

fun <T: R, R> copyData2(source: MutableList<T>, destination: MutableList<R>) {
    for(item in source) {
        destination.add(item)
    }
}

fun <T> copyData3(source: MutableList<out T>, destination: MutableList<T>) {
    for(item in source) {
        destination.add(item)
    }
}

fun <T> copyData4(source: MutableList<T>, destination: MutableList<in T>) {
    for(item in source) {
        destination.add(item)
    }
}

fun main() {
    val s = mutableListOf<Int>()
    val d = mutableListOf<Any>()

    //copyData1(s, d)
    copyData2(s, d)
    copyData3(s, d)
    copyData4(s, d)

    val list: MutableList<out Number>
    //list.add(1)
}