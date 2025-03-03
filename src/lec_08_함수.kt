코틀린에서 함수를 다루는 방법
1. 함수선언문법
2. default parameter
3. named argument
4. 같은 타입의 여러 파라미터 받기 (=가변인자)
---
1.
예제 두 정수를 받아 더 큰 정수를 반환하는 예제
java
public int max(int a, int b) {
    if(a>b){return a}
    return b;
}

kotlin
fun max (a: Int, b: Int): Int {
    return if (a>b) {a} else {b}
}
위와아래는 같다
fun max (a: Int, b: Int): Int =
    if (a>b) {a} else {b}

// 함수대신 =을 사용한 경우, 모두 같은 return 형일 경우 타입 생략 가능
// block {}을 사용하는 경우에는 명시적으로 자료형 적어야함
fun max (a: Int, b: Int) =
    if (a>b) {a} else {b}

fun max (a: Int, b: Int) = if (a>b) {a} else {b} // 한줄 작성도 가능

fun max (a: Int, b: Int) = if (a>b) a else b // 중괄호 삭제 가능

2.
주어진 문자열을 N번 출력하는 예제
java
public void repeat (String str, int num, boolean useNewLine) {
    for int(i=1;i<=num;i++) {
        if (useNewLine) {
            Sysout(str);
        } esle {
            sysout(str);
        }
    }
}

이 때 많은 코드에서 useNewLine에 true를 사용한다면 Overloading을 사용한다
public void repeat(String str, int num) {
    repeat(str, num, ture); //useNewLine에 기본으로 true가 들어간 함수를 새로 만들어준다.
}

이 때 많은 코드에서 num에 3을 쓴다면...
public void repeat(String str) {
    repeat(str, 3, true)
}

===> 똑같은 이름의 repeat함수를 세개 만들 수 있다.(인자가 다르므로)
===> 근데 같은 함수를 세개씩이나 만들어야하나...(귀찮다)
===> kotlin에는 default prameter라는 기능이 있으니... 밖에서 값 넣어주기 귀찮을 경우 기본값을 넣어주자

K
fun main() {
    repeat("Hello World") // 문제 없음
    repeat("", 3, true) // 도 가능해요
}
fun repeat(
    str: String,
    numL Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str)
        }
    }
}

3.
repeat에서 d.p를 썼는데 num은 3을 쓰고 false를 쓰고 싶을 경우 Named argument를 사용한다.
fun main() {
    repeat("Hello world", useNewLine = false)
}

fun main() {
    prNG("Female","최태현") // 잘못 적을수도있지
// java에서는 builder를 쓰면 더 편했다
        .name()
        .gender()
//K에서는
    prNG(name="최태현", gender="Male") //이케가능
//builder를 안 만들고도 builder처럼 쓰기 가능
}
fun printNameAndGender(name:Stirng, gender:String) {
}

4.
문자열을 N개 받아 출력 예제
J
String[] array = new String[]{"a","b","c"};
printAll(array);
printAll("a","b","c");
public static void printAll(String... strings) { // String 타입의 n개의 파라미터를 받는다. ...을 사용하면 가변인자 사용이 가능하다.
    for (Stirng str : strings) {
        sysout(str);
    }
}

K
fun main() {
    printAll("a","b","c")
    val array = arrayOf("a","b","c")
    printAll(*array) // 스프레드 연산자!!!
}
fun printAll(vararg strings: String) { // valarg!!!
    for(str in strings) {println(str)}
}

