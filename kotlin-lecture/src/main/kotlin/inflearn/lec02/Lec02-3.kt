package inflearn.lec02

fun main() {
    println(startsWithA("ABC"));
    println(startsWithA(null));
}

fun startsWithA(str: String?): Boolean {
    return str!!.startsWith("A");
}