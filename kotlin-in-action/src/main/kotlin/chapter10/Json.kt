package chapter10

fun main() {
    val person = Person("hi", 10)
    //println(serialize(person))

    val json = """
        {
            "name": "hi"
            "age": 10
        }
    """.trimIndent()
    //println(deserialize<Person>(json))
}

data class Person(
    /*@JsonName("name")*/ val name: String,
    /*@JsonName("age")*/ val age: Int
)
