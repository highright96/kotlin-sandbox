package chapter07

class Point(var x: Int, var y: Int) : Comparable<Point> {
    operator fun plus(other: Point) =
        Point(x + other.x, y + other.y)

    operator fun times(scale: Double) =
        Point((x * scale).toInt(), (y * scale).toInt())

    operator fun plusAssign(other: Point) {
        x += other.x
        y += other.y
    }

    operator fun unaryMinus() = Point(-x, -y)

    override fun compareTo(other: Point) =
        compareValuesBy(this, other, Point::x, Point::y)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    operator fun get(index: Int) = when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(index: Int, value: Int) =
        when(index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException()
        }

    operator fun component1() = x
    operator fun component2() = y
}

fun main() {
    println(Point(1, 1) + Point(2, 2))
    val p = Point(1, 1)
    p += Point(2, 2)
    println(p)

    val numbers = ArrayList<Int>()
    numbers += 1

    val list = arrayListOf(1, 2)
    list + 3

    val newList = list + listOf(4, 5)

    println(list)
    println(newList)

    val a = listOf(1, 2)
    val b = a + listOf(3, 4)
    println(a)
    println(b)

    println(p[0])
    p[0] = 10
    println(p)
}