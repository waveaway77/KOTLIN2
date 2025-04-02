package code.C_19_block.A

/*
execute 함수:
이 함수는 inline 키워드로 선언되어 있어, 호출될 때 함수의 본문이 호출 지점에 직접 삽입됩니다.
action이라는 람다 매개변수를 받으며, 이 매개변수는 crossinline으로 표시되어 있습니다.
 */
inline fun execute(crossinline action: ()->Unit) { // NameResultContext.() -> Unit과 같은 표현은 수신 객체 타입(receiver type)이 NameResultContext인 확장 함수 타입
    // 이처럼 함수 이름이 생략된 NameResultContext.() -> Unit 표현은
    // 특정 클래스의 컨텍스트에서 실행되는 익명 확장 함수를 정의할 때 사용됩니다.
    // 이를 통해 해당 클래스의 멤버를 직접 호출하거나 프로퍼티에 접근할 수 있습니다.
    println("작업 시작")
    action()
    println("작업 종료")
}

/*
execute 함수를 호출하면서 action 람다를 전달합니다. (람다호출4 참고)
이 람다는 "실행 중"이라는 메시지를 출력합니다.
 */
fun main() {
    code.C_19_block.B.execute {
        println("실행 중")
    }
}
//작업 시작
//실행 중
//작업 종료

/*
inline 함수는 함수 호출을 본문으로 대체하여 성능을 향상시킬 수 있습니다.
https://www.youtube.com/watch?v=Itb5fu4UVt4
 */