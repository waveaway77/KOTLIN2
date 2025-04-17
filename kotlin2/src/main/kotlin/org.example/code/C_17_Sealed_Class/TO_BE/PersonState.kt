package code.C_17_Sealed_Class.TO_BE

// sealed class란 추상 클래스로 상속 받는 자식 클래스의 종류를 제한하는 특성을 가지고 있다.
// 즉, 컴파일러에서 sealed class의 자식 클래스가 어떤 것이 있는지 알 수 있다.

sealed class PersonState

class Running : PersonState()
class Walking : PersonState()
class Idle : PersonState()
//class RunningFast : PersonState()

fun getStateMessage(personState: PersonState): String {
    return when (personState) {
        is Running -> "Person is running"
        is Walking -> "Person is walking"
        is Idle -> "Person is doing nothing"
        // else가 없어도 컴파일 에러가 발생하지 않는다.
        // 이유는 컴파일러에서 sealed class PersonState의 자식 클래스는 Running, Walking, Idle 세가지만 있는 것을 알고 있기 때문이다.

        // RunningFast 상태가 추가 되었는데 when에 명시하지 않아 컴파일 에러가 발생한다.
    }
}