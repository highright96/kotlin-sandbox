package fastcampus.sealed_class

object DeveloperPool {

    private val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> pool[developer.name] = developer
    }

    fun get(name: String) = pool[name]
}