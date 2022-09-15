package chapter09

open class Animal {
    fun feed() {
        TODO()
    }
}

class Herd<out T : Animal>(
    val leadAnimal: T,
    //var leadAnimal2: T
) {
    operator fun get(i: Int): T {
        TODO()
    }
}

fun feedAll(animals: Herd<Animal>) {
    TODO()
}

class Cat : Animal() {
    fun cleanLitter() {
        TODO()
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    cats[1].cleanLitter()
    //feedAll(cats)
}