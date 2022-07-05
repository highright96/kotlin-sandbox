package inflearn.lec10

interface Swimable {

    val swimAbility: Int
        get() = 3

    fun act() {
        println(swimAbility)
        println("어푸 어푸")
    }
}