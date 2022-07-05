package fastcampus.sealed_class

class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다. ${language}를 사용합니다.")
    }
}