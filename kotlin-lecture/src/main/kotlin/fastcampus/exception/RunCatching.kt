package fastcampus.exception

import java.lang.Exception

fun getStr(): Nothing = throw Exception("예외 발생!")

fun main() {

    /*
    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본값"
    }

    println(result)
    */

    val result1 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본 값"
        }
    println(result1)

    val result2 = runCatching { getStr() }
        .getOrNull()
    println(result2)

//    val result3 = runCatching { getStr() }
//        .exceptionOrNull()
//    result3?.let {
//        println(it.message)
//        throw it
//    }

    val result4 = runCatching { getStr() }
        .getOrDefault("기본 값")
    println(result4)

//    val result5 = runCatching { getStr() }
//        .getOrThrow()

    val result6 = runCatching { "안녕" }
        .map {
            "${it}하세요"
        }.getOrThrow()
    println(result6)

    val result7 = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }.getOrNull()
    println(result7)

    val result8 = runCatching { getStr() }
        .recover { "복구" }
        .getOrNull()
    println(result8)

    val result9 = runCatching { getStr() }
        .recoverCatching { throw Exception("예외") }
        .getOrNull()
    println(result9)
}