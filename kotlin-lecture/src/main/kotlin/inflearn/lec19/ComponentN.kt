package inflearn.lec19

data class Person(
    val name: String,
    val age: Int,
    var hobby: String = "취미"
)

class Student(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

fun main() {
    val person = Person("남상우", 100)
    val (name, age) = person //순서가 중요하다.
    /*
    위 코드는 아래 코드를 축약한 것이다.
    data 클래스는 기본적으로 자신이 가지고 있는 필드에 대해서 component 함수를 가지고 있다.
    component1은 첫번 째 프로퍼티를 가져온다.

    val name = person.component1()
    val age = person.component2()
    */
    println("이름 : $name 나이 : $age")

    /*
    data 클래스가 아닌 경우 component 함수를 직접 구현해줄 수 있다.
    */
    val student = Student("남상우", 50)
    val (sName, sAge) = student
    println("이름 : $sName 나이 : $sAge")
}