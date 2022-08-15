package chapter06

interface Processor<T> {
    fun process() : T
}

class NoResultProcessor : Processor<Unit> {
    override fun process() {
        TODO("Not yet implemented")
    }
}