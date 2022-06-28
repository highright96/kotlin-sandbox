package lec08

fun main() {
    repeat("안녕하세요")
    repeat("안녕하세요", 4)
    repeat("안녕하세요", 5, false)
}

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

