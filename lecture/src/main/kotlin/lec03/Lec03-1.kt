package lec03

fun main() {
    typeChange()
}

fun type() {
    val number1 = 3 // Int
    val number2 = 3L // Long
    val number3 = 3.0f //Float
    val number4 = 3.0 //double
}

fun typeChange() {
    val number1 = 2;

    /*
    val number2: Long = number1 Type mismatch
    println(number1 + number2);
    */

    val number2: Long = number1.toLong()
    val number3 = 4

    val result = number1 / number3.toDouble();
    println(result)
}

fun typeIfNull() {
    val number1: Int? = null
    val number2: Long = number1?.toLong() ?: 0L
}