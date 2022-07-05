package inflearn.lec20

import lec14.PersonDto
import lec19.Person

fun main() {

}

fun printPerson(person: Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }

    if (person != null) {
        println(person.name)
        println(person.age)
    }

    val personA = Person("a", 10)
    val value1 = personA.let {
        it.age
    }

    val value2 = personA.run {
        this.age
    }

    val value3 = personA.also {
        it.age
    }

    val value4 = personA.apply {
        this.age
    }

    with(personA) {
        println(name)
        println(this.age)
    }

    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
        .filter { it > 3 }
        .let { lengths -> println(lengths) }

    val str = "a"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

    val firstString = strings.first()
        .let { firstString ->
            if (firstString.length >= 5) firstString else "!$firstString"
        }.uppercase()

    mutableListOf("one", "two")
        .also { println("before : $it") }
        .add("three")

    val numbers = mutableListOf("one", "two")
    println("before : $numbers")
    numbers.add("three")
}

fun createPerson(
    name: String,
    age: Int,
    hobby: String
): Person {
    return Person(
        name = name,
        age = age
    ).apply {
        this.hobby = hobby
    }
}

fun toPersonDto(person: Person) {
    return with(person) {
        PersonDto(
            name = name,
            age = age
        )
    }
}