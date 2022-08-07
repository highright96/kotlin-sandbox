package chapter05

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I Know the alphabet!")
    return result.toString()
}

fun alphabetWith() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I Know the alphabet!")
    toString()
}

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I Know the alphabet!")
}.toString()

fun alphabetBuildingString() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I Know the alphabet!")
}

fun main() {
    //println(alphabet())
    println(alphabetBuildingString())
}