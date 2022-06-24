package chapter05

data class Golfer(val score: Int, val first: String, val last: String)

fun main() {
    val golfers = listOf(
        Golfer(70, "a", "a"),
        Golfer(80, "b", "b"),
        Golfer(80, "c", "c"),
        Golfer(80, "c", "a"),
    )

    //점수, 성, 이름 순으로 정렬
    val sorted = golfers.sortedWith(
        compareBy({ it.score }, { it.first }, { it.last })
    )
    println(sorted)
}