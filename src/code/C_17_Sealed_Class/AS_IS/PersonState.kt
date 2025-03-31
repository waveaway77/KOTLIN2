package code.C_17_Sealed_Class.AS_IS

/* https://kotlinworld.com/165 */

// 우리는 사람의 상태를 클래스로 만들고자 한다.
abstract class PersonState

// 상태의 종류는 3가지로 뛰는 상태(Running), 걷는 상태(Walking), 쉬는 상태(Idle)가 있다
class Running : PersonState()
class Walking : PersonState()
class Idle : PersonState()

fun getStateMessage(personState: PersonState): String {
    return when (personState) { // else 가 없을 경우 에러가 발생한다.
        // 이 이유는 컴파일러가 PersonState를 상속 받는 하위 클래스의 종류를 전부 파악할 수 없기 때문이다
        is Running -> "Person is running"
        is Walking -> "Person is walking"
//        is Idle -> "Person is doing nothing" 만약 이 코드가 삭제되고 릴리즈 됐다고 생각해보자
// Idle 상태에 대한 처리가 없으므로 애플리케이션이 동작하지 못할 것이다.
// 즉 코드에 문제가 있더라도 컴파일 단에서 잡아내지 못하고 오류도 찍히지 않아 문제를 잡아내기가 매우 힘들어진다.
        else -> "No state"
    }
}

// Sealed Class는 이런 문제를 해결하기 위해 등장했다.