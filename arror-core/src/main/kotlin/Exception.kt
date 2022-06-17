import arrow.core.Either
import arrow.core.flatMap

sealed class Errorr {

    object NotANumber : Errorr()
    object NoZeroReciprocal : Errorr()
}

fun main() {
    val x = magic("abc")
    val v = when (x) {
        is Either.Left -> when (x.value) {
            is Errorr.NotANumber -> "Not a number!"
            is Errorr.NoZeroReciprocal -> "Can't take reciprocal of 0!"
        }
        is Either.Right -> "Got reciprocal: ${x.value}"
    }

    println(v)
}

/*
flatMap -> Right인 경우 람다식 실행, Left인 경우 리턴
 */
fun magic(s: String): Either<Errorr, String> =
    parse2(s).flatMap {
        println("flatMap")
        reciprocal(it)
    }.map {
        println("map")
        stringify(it)
    }

fun reciprocal(i: Int): Either<Errorr, Double> =
    if (i == 0) Either.Left(Errorr.NoZeroReciprocal)
    else Either.Right(1.0 / i)

fun stringify(d: Double): String = d.toString()

fun parse1(s: String): Int =
    if (s.matches(Regex("-?[0-9]+"))) s.toInt()
    else throw NumberFormatException("$s is not a valid integer.")

fun parse2(s: String): Either<Errorr, Int> =
    if (s.matches(Regex("-?[0-9]+"))) Either.Right(s.toInt())
    else Either.Left(Errorr.NotANumber)