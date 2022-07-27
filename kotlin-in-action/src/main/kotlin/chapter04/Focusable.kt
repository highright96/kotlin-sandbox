package chapter04

interface Focusable {
    fun setFocus(b: Boolean) = println("$b")
    fun showOff() = println("I'm focusable!")
}