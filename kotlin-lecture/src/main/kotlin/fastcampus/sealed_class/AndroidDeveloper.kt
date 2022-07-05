package fastcampus.sealed_class

class AndroidDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다. ${language}를 사용합니다.")
    }
}