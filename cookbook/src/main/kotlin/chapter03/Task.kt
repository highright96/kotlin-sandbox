package chapter03

class Task(val name: String, _priority: Int = DEFAULT_PRIORITY) {

    companion object {
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 5
        const val DEFAULT_PRIORITY = 3
    }

    val isLowPriority
        get() = priority < 3

    var priority = validPriority(_priority)
        set(value) {
            field = validPriority(value)
        }

    private fun validPriority(p: Int) = p.coerceIn(MIN_PRIORITY, MAX_PRIORITY)
}

fun main() {
    var myTask = Task("name").apply {
        priority = 4
    }

    val isLow = myTask.isLowPriority
    println(isLow)
}