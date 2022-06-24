package chapter05

data class Player(val name: String)

class Team(val name: String, val players: MutableList<Player>) {

    operator fun Team.iterator(): Iterator<Player> = players.iterator()
}

fun main() {
    val team = Team("team", mutableListOf(Player("a")))
}