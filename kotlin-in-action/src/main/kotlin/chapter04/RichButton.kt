package chapter04

class RichButton : Clickable {
    fun disable() {} // final, 오버라이드 불가능
    open fun animate() {} // 오버라이드 가능
    override fun click() {} // 오버라이드 가능
}