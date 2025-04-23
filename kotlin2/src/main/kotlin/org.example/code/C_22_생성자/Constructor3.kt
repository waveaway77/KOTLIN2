package org.example.org.example.code.C_22_생성자

class DummyService;
class DummyClass(private val dummyService: DummyService) // 클래스를 생성자로 받는 코드
// private val이 붙어 있기 때문에, 이 파라미터는 클래스의 프로퍼티로 저장된다.
// 즉, dummyService는 생성자에 전달되며 동시에 DummyClass의 멤버 변수로도 존재하게 된다.

fun someFunction(dummyService: DummyService) {
    // 여기서만 사용되는 지역 변수
}
// val이나 var없이 함수의 괄호 안에 있는 경우, 이건 그 함수에서만 쓰이는 파라미터다.
// 클래스의 멤버 변수로 저장되지 않는다.

/* 왜 이런 짓을 하는가? */
/*
✅ 생성자 주입의 장점
1. 불변성(immutability) 보장
생성자 주입을 사용하면, 주입된 의존성(예: DummyService)은 val로 선언되므로 변경 불가능하다.
이는 코드의 안정성을 높이고, 의도하지 않은 변경을 막는다.

2. 의존성이 없으면 인스턴스 생성 자체가 실패
생성자 주입에서는 필수 의존성을 반드시 넣어야 한다.
그래서 컴파일 타임이나 애플리케이션 실행 시점에, 주입이 누락되었는지를 빠르게 알 수 있다. ==> 꼭!!! 필요한 기능을 가진 서비스를 주입하면 안전하겠군

3. 테스트하기 쉬움
테스트 코드에서 해당 클래스를 인스턴스화할 때, 의존성을 직접 주입할 수 있으므로 모킹(mocking)이 편함.

val mockService = mockk<DummyService>()
val controller = DummyController(mockService)

4. 순환 참조(circular dependency)를 피하기 쉬움
생성자 주입은 순환 참조를 조기에 탐지할 수 있어서, 앱의 구조를 더 명확하게 만든다.
*/