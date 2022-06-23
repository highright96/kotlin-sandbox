package chapter05

fun main() {
    val keys = 'a'..'f'
    val map = keys.associateWith { key -> key.toString().repeat(5) }
    println(map)
}