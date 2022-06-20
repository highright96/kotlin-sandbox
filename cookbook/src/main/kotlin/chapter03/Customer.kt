package chapter03

class Customer(val name: String) {
    private var _messages: List<String>? = null

    val messages: List<String>
        get() {
            if (_messages == null) {
                _messages = loadMessages()
            }
            return _messages!!
        }

    private fun loadMessages(): MutableList<String> =
        mutableListOf(
            "a",
            "b",
            "c"
        ).also { println("Loaded messages") }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        val o = (other as? Customer) ?: return false
        return (this.name == o.name)
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

fun main() {
    val customer = Customer("name").apply { messages }
    println(customer.messages.size)
}