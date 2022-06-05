package lec02

fun main() {
    println(startsWithA("ABC"));
    println(startsWithA(null));
}

/*
nullable type이지만, 아무리 생각해도 null이 될 수 없는 경우
만약 null이 들어오면 NPE가 발생한다.
따라서 정말 null이 아닌게 확실한 경우에만 널 아님 단언!! 을 사용해야 한다.
*/

fun startsWithA(str: String?): Boolean {
    return str!!.startsWith("A");
}