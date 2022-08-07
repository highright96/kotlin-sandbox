package chapter05

data class Person(val name: String, val age: Int)

fun main() {
    val persons = listOf(Person("aaa", 29), Person("bbb", 31))
    println(persons.maxByOrNull { it.age })
    println(persons.maxByOrNull(Person::age))
    println(persons.maxByOrNull { p -> p.age })
    println(persons.maxByOrNull { p: Person -> p.age })

    val getAge = { p: Person -> p.age }
    persons.maxByOrNull(getAge)

    val sum = {x: Int, y: Int ->
        println("sum ... ")
        x + y
    }
}