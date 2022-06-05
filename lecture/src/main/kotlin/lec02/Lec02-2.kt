package lec02

import java.lang.IllegalArgumentException

fun main() {
    /*
    Kotlin에서는 null이 가능한 타입을 완전히 다르게 취급한다.
    null이 가능한 타입만을 위한 기능은 없는가?
    */

    /*
    Safe Call
    null이 아니면 실행하고
    null이면 실행하지 않는다 (그대로 null)
    */
    val str: String? = null;
    //println(str.length); 컴파일 에러
    println(str?.length);

    /*
    Elvis 연산자
    앞의 연산 결과가 null이면 뒤의 값을 사용
    */
    val nullStr: String? = null;
    println(nullStr?.length ?: 0);
}

fun startsWithA1Elvis(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다.");
}

fun startsWithA2Elvis(str: String?): Boolean? {
    return str?.startsWith("A");
}

fun startsWithA3Elvis(str: String?): Boolean {
    return str?.startsWith("A") ?: false;
}

fun earlyReturn(number: Long?): Long {
    number ?: return 0;

    //다음 로직
    return 1;
}