package chapter08

fun main() {
    val ultimateAnswer: Int by lazy {
        println("computing")
        42
    }

    println(ultimateAnswer)
    println(ultimateAnswer)
}