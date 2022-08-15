package chapter06

fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T: Any> printHashCodeNotNull(t: T) {
    println(t.hashCode())
}

fun main() {
    printHashCode(null)
    //printHashCodeNotNull(null)
}