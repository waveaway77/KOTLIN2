package lecture/*
1.확장함수
2.infix함수 (중위함수)
3.inline함수
4.지역함수
---
1.
함수의 코드 자체는 클래스 밖에 있는데, 마치 클래스 안에 있는 멤버 함수처럼 호출해서 쓴다.
*/

/*
fun 확장하려는클래스(this의타입으로 수신객체타입이라고부른다).함수이름(파라미터): 리턴타입 {
fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
  // this(수신객체)를 이용해 실제 클래스 안의 값에 접근한다
}
 */
fun main() {
    val str = "ABC"
    str.lastChar()
}

fun String.lastChar(): Char { // 확장함수 (String class밖에 있는데도 19라인에서 호출이 잘 되네용)
    return this[this.length - 1]
}

// 2. infix 함수
// 변수.함수이름(argument) >>> 변수 함수이름 argument
fun calling() {
    3.add(4)
    3.add2(4)
    3 add2 4 //infix
}
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

// 3. inline 함수
// 함수가 호출되는 대신 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우

// 4. 지역함수
// 함수 안에 함수를 선언한다
