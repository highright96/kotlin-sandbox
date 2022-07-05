package fastcampus.sealed_class

class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다. ${language}를 사용합니다.")
    }
}