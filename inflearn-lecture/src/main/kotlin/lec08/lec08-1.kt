package lec08

fun max1(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun max2(a: Int, b: Int): Int =
    if (a > b) {
        a
    } else {
        b
    }

fun max3(a: Int, b: Int) = if(a > b) a else b