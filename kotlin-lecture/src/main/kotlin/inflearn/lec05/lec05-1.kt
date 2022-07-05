package inflearn.lec05

fun main() {

}

fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다")
    }
}

fun getPassOrFailA(score: Int): String {
    if (score >= 50) {
        return "P"
    } else {
        return "F"
    }
}

fun getPassOrFailB(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score >= 50) {
        "P"
    } else if (score >= 40) {
        "F"
    } else {
        "D"
    }
}

fun getRange(score: Int) {
    if (score in 0..50) {
        "P"
    }
}