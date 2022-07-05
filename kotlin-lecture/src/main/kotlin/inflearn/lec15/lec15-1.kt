package inflearn.lec15

fun main() {

    //배열 초기화
    val arr = arrayOf(100, 200)

    //배열 순회
    for (i in arr.indices) {
        println(arr[i])
    }

    //배열 인덱스 + 원소
    for ((idx, value) in arr.withIndex()) {
        println("$idx : $value")
    }

    //원소 추가
    arr.plus(300)
}