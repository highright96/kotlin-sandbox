package chapter07

import chapter05.Product
import java.util.logging.Logger

fun main() {
    val product = Product(
        name = "name",
        price = 10.0
    ).also {
        println(it)
    }.also {
        Logger.getAnonymousLogger().info(it.toString())
    }
}