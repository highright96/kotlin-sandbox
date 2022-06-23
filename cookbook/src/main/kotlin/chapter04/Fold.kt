package chapter04

fun sum(vararg nums: Int) =
    nums.fold(0) { acc, n -> acc + n}

fun sum0(vararg nums: Int) =
    nums.reduce() { acc, n -> acc + n}

fun main() {
    val nums = intArrayOf(1,2,3,4,5)
    println(sum(*nums))
    println(sum0(*nums))
}