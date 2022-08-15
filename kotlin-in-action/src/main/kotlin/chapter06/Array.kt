package chapter06

fun main(args: Array<String>) {
    for(i in args.indices) {
        println("$args[i]")
    }

    val letters = Array(26) { i -> ('a' + i).toString() }
    println(letters.joinToString())
}