package chapter10

import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0

var counter = 10

fun main() {
    val person = Person("a", 10)
    val kClass = person.javaClass.kotlin

    println(kClass.simpleName)
    kClass.members.forEach { println(it) }

    val kFunction = ::foo
    kFunction.call(42)

    kFunction.invoke(42)

    val kProperty = ::counter
    kProperty.setter.call(10)
    println(kProperty.get())

}

fun foo(x: Int) = println("foo!")