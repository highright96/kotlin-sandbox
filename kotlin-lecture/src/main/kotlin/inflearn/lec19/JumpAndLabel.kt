package inflearn.lec19

fun main() {
    val arr = listOf(1, 2, 3)

    run {
        arr.forEach { number ->
            if (number == 2) {
                return@run
            }
        }
    }

    arr.forEach { number ->
        if (number == 2) {
            return@forEach
        }
    }

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop
            }
            println(j)
        }
    }
}