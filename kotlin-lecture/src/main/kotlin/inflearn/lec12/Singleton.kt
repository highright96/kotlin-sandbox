package inflearn.lec12

fun main() {
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
}

object Singleton {
    var a: Int = 0
}