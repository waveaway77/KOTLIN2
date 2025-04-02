package code.C_19_block.B

/*
printMessage라는 멤버 함수를 포함하고 있습니다.
 */
class NameResultContext {
    fun printMessage() {
        println("Hello from class")
    }
}

/*
매개변수 block은 NameResultContext.() -> Unit 타입의 익명 확장 함수를 받습니다.
이는 NameResultContext의 인스턴스를 수신 객체로 하는 익명 함수를 의미합니다.
 */
fun execute(block: NameResultContext.()->Unit) {
    val context = NameResultContext()
    context.block() // execute 함수가 호출되면서 block에 해당하는 람다(printMessage)를 전달합니다.
                    // context.printMessage가 실행된다
}

/*
execute 함수를 호출하면서 block 람다(printMessage)를 전달합니다.
이 람다 내부에서는 NameResultContext의 멤버인 printMessage 함수를 직접 호출할 수 있습니다.
 */
fun main() {
    execute { // 함수1
        printMessage() // 함수2
    }
}