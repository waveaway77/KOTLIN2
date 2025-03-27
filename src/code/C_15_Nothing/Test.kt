package code.C_15_Nothing
/*
Unit
Java의 void와 대응되는 개념이다.
코틀린은 함수에 리턴이 없으면 Unit타입으로 추론한다.
void가 아니라 Unit객체를 리턴하기 때문에 모든 함수가 표현식이 될 수 있다.
Unit 클래스는 toString() 함수를 가지고 있다.
그렇게 유용하지 않지만, 반환값이 없을 때 생기는 문제점을 처리해준다.
ex) 출력하면 kotlin.Unit으로 나온다.
Any
Java의 Object에 대응되는 클래스이다.
toString(), equals(), hashCode() 함수를 가지고 있다.
모든 코틀린 클래스의 조상(Superclass)이다.
Any는 확장함수를 통해 특별한 메소드들을 제공한다.
Pair를 만들기 위한 to()함수
let(), run(), apply(), also() 등
 */




/*
https://yoonda.tistory.com/18
함수가 아무것도 리턴하지 않을 경우 리턴하는 타입이다.
Java에는 대응되는 타입이 없다.
코틀린에서는 함수가 리턴하지 않을 때, Unit을 사용한다고 했는데 무슨말인가?
가끔 함수가 진짜로 아무것도 리턴하지 않는 상황이 있다.
리턴이라는 행위 자체를 하지 않는 것이다.
    무한 루프
    예외 던지기
Nothing은 인스턴스가 없고, 값이난 결과가 영원히 존재하지 않는다는 것을 나타낸다.
 */
class Test {
    fun computeSqrt(n: Double): Double {
        if (n >= 0) {
            return Math.sqrt(n)
        } else {
            throw RuntimeException("No negative please")
        }
    }

    fun throwException(): Nothing {
        throw Exception()
    }
}
/*
예외를 던지는 것은 리턴하는 행위가 아니다. 이런 경우 아무 것도 리턴되지 않는 것이다.
computeSqrt()에서 if 문은 Double을 반환하고, else는 Nothing을 반환한다.
근데 반환값은 왜 Double만 있고, Nothing은 없을까?
Nothing은 모든 클래스로 대체될 수 있다. 모든 클래스의 서브(자식)클래스이기 때문이다.
 */