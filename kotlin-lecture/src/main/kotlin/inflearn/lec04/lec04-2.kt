package inflearn.lec04

fun main() {
    if(fun1() || fun2()) {
        println("main")
    }
}

fun fun1(): Boolean {
    println("fun 1")
    return true;
}

fun fun2(): Boolean {
    println("fun 2")
    return false;
}