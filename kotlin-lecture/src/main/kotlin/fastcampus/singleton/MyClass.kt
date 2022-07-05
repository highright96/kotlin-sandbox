package fastcampus.singleton

class MyClass private constructor() {

    // MyClass 의 동반 객체
    companion object {
        val a = 1234

        fun newInstancce() = MyClass()
    }
}