package chapter2

/*
Optional 이나 널 혀용 속성 함수는 시그니처의 마지막에 위치시켜야 한다.
그래야만 생략이 가능하다.
*/
fun addProduct(name: String, price: Double = 0.0, desc: String? = null) = "" +
        "$name, ${desc ?: "None"}"

fun main() {
    println(addProduct("name", 1.5))
    println(addProduct("name"))
}