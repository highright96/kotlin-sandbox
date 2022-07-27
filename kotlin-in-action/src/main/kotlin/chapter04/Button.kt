package chapter04

class Button : Clickable, Focusable, View {
    override fun click() = println("Click!")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun getCurrentState(): State = ButtonState()

    class ButtonState : State

    inner class Inner
}

fun main() {
    val button = Button()
    val inner = Button().Inner()
    button.showOff()


    val button2 = Button2()
    button2.getCurrentState()
}