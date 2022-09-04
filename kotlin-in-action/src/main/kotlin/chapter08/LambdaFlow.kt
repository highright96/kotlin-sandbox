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

fun <T> Iterable<T>.forEachNotInline(action: (T) -> Unit): (T) -> Unit {
    val a = action
    return a
}

//inline fun <T> Iterable<T>.forEachInline(action: (T) -> Unit): (T) -> Unit {
//    return action // 컴파일 에러
//}

fun lookForAliceWithLambda(people: List<Person>) {
    val a = 10
    people.forEach {
        if(it.name == "b") {
            println("found!")
            return
        }
    }
    println("not found")
}

fun lookForAliceB(people: List<Person>) {
    people.forEachNotInline {
        if(it.name == "b") {
            println("found!")
            return@forEachNotInline
        }
    }
    println("not found")
}

fun main() {
    lookForAlice(people)
    lookForAliceWithLambda(people)
}