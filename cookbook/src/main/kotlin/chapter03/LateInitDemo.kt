package chapter03

class LateInitDemo {
    lateinit var name: String

    fun initial() {
        println("Before")
        name = "world"
        println("After")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LateInitDemo

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

fun main() {
    println(LateInitDemo().initial() == LateInitDemo().initial())
}