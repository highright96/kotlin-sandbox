package lec10

fun main() {
    val drived = Drived(50)
    println(drived.number) //하위 클래스의 number 변수가 초기화 되지 않아 0을 출력
}

open class Base(
    open val number: Int = 100
) {
    init {
        println("Base Class")
        println(number)
    }
}

class Drived(
    override val number: Int
) : Base(number) {
    init {
        println("Derived Class")
    }
}