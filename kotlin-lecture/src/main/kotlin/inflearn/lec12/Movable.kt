package inflearn.lec12

fun main() {
    moveSomething(object : Movable {
        override fun move() {
            println("움직인다")
        }

        override fun fly() {
            println("난다~~")
        }
    })
}

fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

interface Movable {

    fun move()

    fun fly()
}