package fastcampus.sealed_class

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}