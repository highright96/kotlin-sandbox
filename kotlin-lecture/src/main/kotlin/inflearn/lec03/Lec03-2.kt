package inflearn.lec03

import inflearn.lec01.Person

fun main() {

}

fun printNameIfPerson(obj: Any) {
    if(obj is _root_ide_package_.inflearn.lec01.Person) {
        val person = obj as _root_ide_package_.inflearn.lec01.Person
        println(person.name)
    }

    if(obj is _root_ide_package_.inflearn.lec01.Person) {
        println(obj.name)
    }
}

fun printNameIfNotPerson(obj: Any) {
    if(obj !is _root_ide_package_.inflearn.lec01.Person) {
        //내용
    }
}

fun printNameIfPersonNull(obj: Any?) {
    val person = obj as? _root_ide_package_.inflearn.lec01.Person ?: throw java.lang.IllegalArgumentException("null이 들어왔습니다.")
}