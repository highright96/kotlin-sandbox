package fastcampus.sealed_class

object OtherDeveloper : Developer() {
    override val name: String = "익명"

    override fun code(language: String) {
        println("저는 개발자입니다. ${language}를 사용합니다.")
    }
}