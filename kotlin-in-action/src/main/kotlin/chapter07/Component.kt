package chapter07

fun main() {
    val p = Point(1, 2)
    val (x, y) = p
    println(x)
    println(y)

    val map = mapOf("oracle" to "java", "jetbrains" to "kotlin")
}

fun printEntries(map: Map<String, String>) {
    for((x, y) in map) {
        // ...
    }

    for(entry in map.entries) {
        val key = entry.component1()
        val value = entry.component2()
    }
}

data class NameComponents(
    val name: String,
    val extension: String
) {
    fun splitFilename(fullName: String) : NameComponents {
        val (name, extension) = fullName.split(',', limit = 2)
        return NameComponents(name, extension)
    }
}