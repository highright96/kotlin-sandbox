package lec02

fun main() {

}

/*
타입 끝에 ?를 붙이면 null이 들어올 수 있음을 명시하는 것이다.
타입 끝에 ?를 붙이지 않으면 null이 들어올 수 없음을 명시하는 것이다.
*/
fun startsWithA1(str: String?): Boolean {

    //str.startsWith("A"); null이 가능한 변수에 대해 메소드 콜을 할 수 없다.

    if (str == null) {
        throw IllegalArgumentException("널이 들어왔습니다.")
    }

    return str.startsWith("A");
}

fun startsWithA2(str: String?): Boolean? {
    if (str == null) {
        return null;
    }

    return str.startsWith("A");
}

fun startsWithA3(str: String?): Boolean {
    if (str == null) {
        return false;
    }

    return str.startsWith("A");
}