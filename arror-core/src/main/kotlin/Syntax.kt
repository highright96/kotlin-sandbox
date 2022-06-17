import arrow.core.*

fun main() {
    val x1 = Either.Left(10)
    val x2 = Either.Right(15)
    val value = x1.getOrHandle { 7 } //right -> 바로 반환, left -> {} 블록 실행

    println(value)

    val y: Either<Int, Int> = 7.right()
    val fold = y.fold( { it }, { it + 10} ) //왼쪽 : ifLeft, 오른쪽 : ifRight

    println(fold)

    val n = Either.Left(null).leftIfNull { -1 }
    println(n)
}