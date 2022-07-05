package inflearn.lec15

fun main() {

    val oldMap = mutableMapOf<Int, String>()

    oldMap.put(0, "SUNDAY")
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println("$key : $value")
    }
}