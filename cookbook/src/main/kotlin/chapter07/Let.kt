package chapter07

fun main() {
    println(processString(" "))
    println(processString(null))

    val numbers = mutableListOf("123", "21234", "323")
    //출력을 위해 results 임시 변수 사용
    val results = numbers.map { it.length }.filter { it > 3 }
    println(results)

    numbers.map { it.length }.filter { it >= 3 }
        .let {
            println(it)
        }
}

fun processString(str: String?) =
    str?.let {
        when {
            it.isEmpty() -> "Empty"
            it.isBlank() -> "Blank"
            else -> it.uppercase()
        }
    } ?: "Null"

