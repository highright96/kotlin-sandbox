package chapter11

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.net.URL

class AstroRequest {
    companion object {
        private const val ASTRO_URL =
            "http://api.open-notify.org/astros.json"
    }

    operator fun invoke(): AstroResult {
        val response = URL(ASTRO_URL).readText()
        return Gson().fromJson(response, AstroResult::class.java)
    }
}

data class AstroResult(
    val message: String,
    val number: Number,
    val people: List<Assignment>
)

data class Assignment(
    val craft: String,
    val name: String
)

fun main() {
    val result = AstroRequest()
    println(result())
}