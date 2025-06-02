import org.junit.jupiter.api.*
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores
import java.lang.Thread.sleep

@DisplayNameGeneration(ReplaceUnderscores::class)
class EtcTest {
    @Test
    @Disabled
    fun test() {
        println("test")
    }

    @Test
    @DisplayName("두 수 더하기 테스트")
    fun successAddTwoNumbers() {
        Assertions.assertEquals(10, 10)
    }

    @Test
    fun 두_수_더하기_테스트2() {
        Assertions.assertEquals(10, 10)
    }

    @Test
    @Timeout(1)
    @Throws(InterruptedException::class)
    fun timeoutTest() {
        sleep(2000)
    }
}