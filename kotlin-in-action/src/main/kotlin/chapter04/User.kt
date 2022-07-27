package chapter04

open class User constructor(val nickname: String)

class TwitterUser(nickname: String) : User(nickname)

fun main() {
    val user = TwitterUser("abc")
    println(user.nickname)
}