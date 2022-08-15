package chapter06

fun verify(input: String?) {
    if(input.isNullOrBlank()) {
        val nullable = input
        println("Null or Blank!")
    }

    input?.let {
        val notNullable = it
        println("Not null")
    }
}