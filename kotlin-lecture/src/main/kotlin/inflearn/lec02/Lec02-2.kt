package inflearn.lec02

import java.lang.IllegalArgumentException

fun main() {
    val str: String? = null;
    //println(str.length); 컴파일 에러
    println(str?.length);

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