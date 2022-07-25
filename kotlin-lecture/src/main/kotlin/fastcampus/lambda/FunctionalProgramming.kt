package fastcampus.lambda

fun main() {
    val list = mutableListOf(printHello)
    val func = list[0]
    func()

    call(printHello)
    //call(printNo()) 컴파일 에러

    val list2 = mutableListOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }
    forEachStr(list2, printStr)
    forEachStr(list2) {
        println(it)
    }

    // 람다 래퍼런스
    val numberList = listOf("1", "2", "3")
    numberList.map { it.toInt() }.forEach { println(it) }
    numberList.map(String::toInt).forEach(::println)
}

val printHello: () -> Unit = { println("hello") }

inline fun call(block: () -> Unit) {
    block()
}

// fun 을 사용하면 일급 객체가 아니다.
fun printNo() = println("No!")

val printMessage: (String) -> Unit = { println(it) }

val plus: (Int, Int) -> Int = { a, b -> a + b }

// 고차 함수
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for(item in collection) {
        action(item)
    }
}

// 익명함수와 람다 식
fun outerFunc(): () -> Unit = { println("hi") }
val sum = {x: Int, y: Int -> x + y }