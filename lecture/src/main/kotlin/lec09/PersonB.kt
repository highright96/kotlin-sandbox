package lec09

fun main() {
    var person = PersonB("남상우1", 100)
    println(person.name)
    person.age = 10

    person = PersonB("남상우2")
    person = PersonB()
}

class PersonB(
    name: String,
    var age: Int
) {
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }

        println("초기화 블록")
    }

    constructor(name: String) : this(name, 1) {
        println("첫 번째 부생성자")
    }

    constructor() : this("홍길동") {
        println("두 번째 부생성자")
    }

    fun isAdult1(): Boolean {
        return this.age >= age
    }

    val isAdult2: Boolean get() = this.age >= 20

    val isAdult3: Boolean
        get() {
            return this.age >= 20
        }

    /*
    var name: String = name
        get() = field.uppercase()
    */

    var name = name
        set(value) {
            field = value.uppercase()
        }

    val upperCaseName: String
        get() = this.name.uppercase()
}