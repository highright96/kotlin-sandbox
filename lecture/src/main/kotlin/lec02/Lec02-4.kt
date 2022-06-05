package lec02

import lec01.Person

/*
코틀린이 null 관련 정보를 알 수 없는 타입이면 Runtime 시 Exception이 날 수 있다.
Person 클래스의 getName() 메소드에 @Nullable or @Notnull 어노테이션이 있어야 코틀린이 인식할 수 있다.
*/

fun main() {
    val person = Person("공부하는 개발자");
    println(startsWithAJava(person.name));
}

fun startsWithAJava(str: String): Boolean {
    return str.startsWith("A");
}