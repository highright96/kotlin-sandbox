package lec11

class Car(
    internal val name: String,
    _price: Int
) {

    var price = _price
        private set
}