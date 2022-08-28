package chapter08

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val logs = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/login", 64.0, OS.LINUX),
    SiteVisit("/signup", 52.0, OS.MAC),
    SiteVisit("/", 22.0, OS.IOS),
    SiteVisit("/", 17.0, OS.ANDROID)
)

val averageWindow = logs
    .filter { it.os == OS.WINDOWS }
    .map(SiteVisit::duration)
    .average()

//fun List<SiteVisit>.averageDurationFor(os: OS) =
//    filter { it.os == os }.map(SiteVisit::duration).average()

val averageMobileDuration = logs
    .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
    .map(SiteVisit::duration)
    .average()

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()