package chapter08

data class Project(val map: MutableMap<String, Any?>) {
    val name: String by map
    var priority: Int by map
    var completed: Boolean by map
}

fun main() {

    println(
        Project(
            mutableMapOf(
                "name" to "a",
                "priority" to 1,
                "completed" to true
            )
        )
    )
}