package inflearn.lec03

import inflearn.lec01.Person

fun main() {

}

fun printNameIfPerson(obj: Any) {
    if(obj is Person) {
        val person = obj as Person
        println(person.name)
    }

    if(obj is Person) {
        println(obj.name)
    }
}

fun printNameIfNotPerson(obj: Any) {
    if(obj !is Person) {
        //내용
    }
}

fun printNameIfPersonNull(obj: Any?) {
    val person = obj as? Person ?: throw java.lang.IllegalArgumentException("null이 들어왔습니다.")
}