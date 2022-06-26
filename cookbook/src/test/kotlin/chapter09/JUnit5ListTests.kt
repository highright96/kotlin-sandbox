package chapter09

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JUnit5ListTests {

    private val strings =
        listOf("this", "is", "a", "list")

    private lateinit var modifiable: MutableList<Int>

    @BeforeEach
    fun setUp() {
        modifiable = mutableListOf(3, 1, 5, 1, 5)
        println("Before $modifiable")
    }

    @AfterEach
    fun finish() {
        println("After: $modifiable")
    }

    @Test
    fun test1() {
        println("Test1")
    }

    @Test
    fun test2() {
        println("Test2")
    }

    @Test
    fun test3() {
        println("Test3")
    }
}