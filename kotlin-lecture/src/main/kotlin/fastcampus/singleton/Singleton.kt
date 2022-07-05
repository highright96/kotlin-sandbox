package fastcampus.singleton

import java.time.LocalDateTime

object Singleton {
    val a = 1234
    fun printA() = print(a)
}

object DatetimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD" // const == 상수

    fun isSame(dateA: LocalDateTime, dateB: LocalDateTime) = dateA == dateB
}

fun main() {
    println(Singleton.a)
    println(Singleton.printA())

    println(DatetimeUtils.now)
    println(DatetimeUtils.DEFAULT_FORMAT)

    //val myClass = MyClass()
    println(MyClass.newInstancce())
    println(MyClass.a)
}