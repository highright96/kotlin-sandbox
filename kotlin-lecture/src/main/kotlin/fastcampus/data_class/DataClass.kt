package fastcampus.data_class

data class Person(val name: String, val age: Int)

fun main() {
    val person1 = Person(name = "highright", age = 27)
    val person2 = person1.copy(name = "sangwoo")

    println(person2)

    val (name, age) = person1
    println("$name, $age")
}