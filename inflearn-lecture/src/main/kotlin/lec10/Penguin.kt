package lec10


class Penguin(
    species: String,
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount = 2

    override fun move() {
        println("꽥꽥")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override val swimAbility: Int
        get() = 100

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }
}