package chapter04

interface JSONFactory<T> {
    fun fromJSON(jsonText: String) : T
}

class JSONPerson(val name: String) {
    companion object : JSONFactory<JSONPerson> {
        override fun fromJSON(jsonText: String): JSONPerson {
            TODO("Not yet implemented")
        }
    }
}

fun JSONPerson.Companion.extensionFunc() = println("Hi!")