package chapter03

object Singleton {
    val myProperty = 3

    fun myFunction() = "Hello"
}

fun main() {
    println(Singleton.myProperty)
    println(Singleton.myFunction())
}