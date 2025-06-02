import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LifeCycleTest {
    @BeforeEach
    fun setUpEachTest() {
        print("BeforeEach -> ")
    }

    @AfterEach
    fun finishAfterEach() {
        println("-> AfterEach")
    }

    @Test
    fun test() {
        print("test")
    }

    @ParameterizedTest
    @CsvSource(value = ["5,5,10"])
    fun parameterTest(number1: Int, number2: Int, expected: Int) {
        print("parameterTest")
    }

    @RepeatedTest(2)
    fun RepeatedTest() {
        print("RepeatedTest")
    }

    companion object {
        @BeforeAll
        fun setUp() {
            println("BeforeAll")
        }

        @AfterAll
        fun finishAllTasks() {
            println("AfterAll")
        }
    }
}