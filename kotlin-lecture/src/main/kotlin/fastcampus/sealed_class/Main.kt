package fastcampus.sealed_class

fun main() {
    DeveloperPool.add(BackendDeveloper(name="A"))
    DeveloperPool.add(FrontendDeveloper(name="B"))
    DeveloperPool.add(AndroidDeveloper(name="C"))
    DeveloperPool.add(OtherDeveloper)

    println(DeveloperPool.get("A")!!.name)
    println(DeveloperPool.get("B")!!.name)
    println(DeveloperPool.get("C")!!.name)
    println(DeveloperPool.get("익명")!!.name)
}