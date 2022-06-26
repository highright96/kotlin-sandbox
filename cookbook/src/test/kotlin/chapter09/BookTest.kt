package chapter09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class BookTest {

    @Test
    fun `use data class`() {
        val book1 = Book(
            "isbn",
            "title",
            "author",
            LocalDate.now()
        )

        val book2 = Book(
            "isbn",
            "title",
            "author",
            LocalDate.now()
        )

        //equals 메소드가 재정의 되어있으면 필드별로 비교할 필요가 없다.
        assertThat(book1).isEqualTo(book2)
    }

    @Test
    fun `use data class array`() {
        val books1 = listOf(
            Book(
                "isbn",
                "title",
                "author",
                LocalDate.now()
            ),
            Book(
                "isbn",
                "title",
                "author",
                LocalDate.now()
            )
        )

        val books2 = listOf(
            Book(
                "isbn",
                "title",
                "author",
                LocalDate.now()
            ),
            Book(
                "isbn",
                "title",
                "author",
                LocalDate.now()
            )
        )

        assertThat(books1).isEqualTo(books2)
    }
}