package chapter08

data class Person(val name: String, val age: Int)

val people = listOf(Person("a", 10), Person("b", 20))

fun lookForAlice(people: List<Person>) {
    for(person in people) {
        if(person.name == "b") {
            println("found!")
            return
        }
    }

    println("not found")
}

fun lookForAliceWithLambda(people: List<Person>) {
    people.forEach {
        if(it.name == "b") {
            println("found!")
            return
        }
    }
    println("not found")
}

fun main() {
    lookForAlice(people)
    lookForAliceWithLambda(people)
}