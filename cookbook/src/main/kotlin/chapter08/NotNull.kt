package chapter08

import kotlin.properties.Delegates

fun main() {

    var shouldBeNull: String? = "abc"
    shouldBeNull = null
    println(shouldBeNull)


    var shouldNotBeNull: String by Delegates.notNull()
    //shouldNotBeNull = null -> 컴파일 에러
    println(shouldNotBeNull)
}