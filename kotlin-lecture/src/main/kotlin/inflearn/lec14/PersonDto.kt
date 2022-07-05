package inflearn.lec14

fun main() {
    val dto1 = PersonDto("남상우", 100)
    val dto2 = PersonDto("남상우", 200)
    val dto3 = PersonDto(name = "남상우", age = 300)

    println(dto1)
    println(dto2)
    println(dto3)
}

data class PersonDto(
    val name: String,
    val age: Int
)