import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.time.Duration
import java.util.*

class AssertionsTest {
    @Test
    fun AssertEqualsTest() {
        Assertions.assertEquals(1, 1)
    }

    @Test
    fun AssertEqualsArrayTest() {
        val A = intArrayOf(1, 2, 3)
        val B = intArrayOf(1, 2, 3)
        Assertions.assertArrayEquals(A, B)
    }

    @Test
    fun AssertIterableEqualsTest() {
        val arrayList: Iterable<String> = ArrayList(mutableListOf("A", "B", "C"))
        val linkedList: Iterable<String> = LinkedList(mutableListOf("A", "B", "C"))
        Assertions.assertIterableEquals(arrayList, linkedList)
    }

    @Test
    fun AssertLinesMatchTest() {
        val expected: List<String> = mutableListOf("Java", "\\d+", "JUnit")
        val actual: List<String> = mutableListOf("Java", "1234", "JUnit")
        Assertions.assertLinesMatch(expected, actual)
    }

    @Test
    fun AssertSameTest() {
        val A = "TEST"
        val B = "TEST"
        Assertions.assertSame(A, B)
    }

    @Test
    fun AssertNotEqualsTest() {
        Assertions.assertNotEquals(1, 2)
    }

    @Test
    fun AssertNotSameTest() {
        val A = "TEST"
        val B = "TEST2"
        Assertions.assertNotSame(A, B)
    }

    @Test
    fun AssertTrueTest() {
        Assertions.assertTrue(true)
    }

    @Test
    fun AssertFalseTest() {
        Assertions.assertFalse(false)
    }

    @Test
    fun AssertNullTest() {
        Assertions.assertNull(null)
    }

    @Test
    fun AssertNotNullTest() {
        Assertions.assertNotNull(Any())
    }

    @Test
    fun AssertAllTest() {
        Assertions.assertAll(
            "SET",
            Executable { Assertions.assertEquals(2, 1 + 1) },
            Executable { Assertions.assertNull(null) },
            Executable { Assertions.assertTrue(true) }
        )
    }

    @Test
    fun AssertThrowsTest() {
        Assertions.assertThrows(
            Exception::class.java
        ) {
            throw Exception("Exception message")
        }
    }

    @Test
    fun AssertTimeoutTest() {
        Assertions.assertTimeout(Duration.ofMillis(200)) {
            Thread.sleep(300)
            println("오래 걸려도 출력합니다.")
        }
    }

    @Test
    fun AssertTimeoutPreemptivelyTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200)) {
            Thread.sleep(300)
            println("오래 걸리면 출력하지 않습니다.")
        }
    }

    @Test
    fun AssertFailTest() {
        fail()
    }
}