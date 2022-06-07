package lec05

fun getGradeWithSwitch(score: Int): String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithRange(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        else -> "C"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A") // String 타입이면
        else -> false
    }
}

fun judgeNumber1(number: Int) {
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.") // 1 또는 0 또는 -1
        else -> println("처음 본 숫자입니다.")
    }
}

fun judgeNumber2(number: Int) {
    //when에 조건이 없어도 사용 가능
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}