import arrow.core.Either
import arrow.core.flatMap

fun main() {
    val right: Either<String, Int> = Either.Right(5)
    var value = right.flatMap { Either.Right(it + 1) }

    println("value = $value")

    val left: Either<String, Int> = Either.Left("something went wrong")
    value = left.flatMap { Either.Right(it + 1) }

    println("value = $value")
}

