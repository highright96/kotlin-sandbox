package chapter05

fun main() {
    val range = 0..10
    val nums1 = range.windowed(3, 1)
    println(nums1)
    // [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9], [8, 9, 10]]

    val nums2 = range.windowed(3, 1) { it.sum() }
    println(nums2)
    // [3, 6, 9, 12, 15, 18, 21, 24, 27]
}