package lec07

import java.lang.NumberFormatException

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw java.lang.IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}

fun parseIntOrNull(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}