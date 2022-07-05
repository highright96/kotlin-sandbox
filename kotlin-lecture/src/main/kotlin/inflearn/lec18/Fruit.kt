package inflearn.lec18

data class Fruit(
    val id: Long?,
    val name: String,
    val factoryPrice: Long = 100,
    val currentPrice: Long = 500
) {

    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice

    fun nullOrValue(): Fruit? {
        if (this.id == null) {
            return null;
        }

        return this;
    }
}