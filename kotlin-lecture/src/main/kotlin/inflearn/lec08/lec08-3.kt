package inflearn.lec08

fun main() {
    repeat("안녕하세요", useNewLine = false)
    printNameAndGender(name = "남상우", gender = "MALE")
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

