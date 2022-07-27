package chapter04

abstract class Animated {
    abstract fun animate() // open
    open fun stopAnimating() {} // open
    fun animateTwice() {} // open X
}