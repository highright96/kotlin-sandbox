package chapter03

class LazyCustomer(val name: String) {

    val messages: List<String> by lazy { loadMessages() }

    private fun loadMessages(): MutableList<String> =
        mutableListOf(
            "a",
            "b",
            "c"
        ).also { println("Loaded messages") }
}