package inflearn.lec04

fun main() {
    val javaMoney1 = JavaMoney(1_000L)
    val javaMoney2 = JavaMoney(2_000L)

    if(javaMoney1 > javaMoney2) {
        println("money1 > money2")
    }
}