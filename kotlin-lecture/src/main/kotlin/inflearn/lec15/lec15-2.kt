package inflearn.lec15

fun main() {

    //불변 리스트 생성
    val numbers = listOf(100, 200)

    //가변 리스트 생성
    val mutableNumbers = mutableListOf(100, 200)

    /*
    비어있는 컬렉션 생성
    아직 값을 넣어주지 않아서 타입을 명시적으로 적어줘야 한다.
    */
    val emptyList = emptyList<Int>()

    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("$idx : $value")
    }

    val setNumbers = setOf(100)
}