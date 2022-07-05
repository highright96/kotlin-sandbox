package inflearn.lec10

/*
추상 클래스
*/
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
) {

    abstract fun move()
}