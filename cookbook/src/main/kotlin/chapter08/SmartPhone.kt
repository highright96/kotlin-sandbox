package chapter08

class SmartPhone(
    private val phone: Dialable = Phone(),
    private val camera: Snappable = Camera()
) : Dialable by phone, Snappable by camera

fun main() {
    val smartPhone = SmartPhone()

    println(smartPhone.dial("010-1111-2222"))
    println(smartPhone.takePicture())
}