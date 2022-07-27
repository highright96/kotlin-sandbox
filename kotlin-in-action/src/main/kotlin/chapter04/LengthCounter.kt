package chapter04

class LengthCounter {
    var counter = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val counter = LengthCounter()
}