package lecture/*
1. how to check null in Kotlin
2. Safe Call, Elvis
3. 널 아님 단언하는 방법
4. platform type : 코틀린이 null 관련 정보를 알 수 없는 타입
*/

fun main() {
    safeCall()
    println(startsWith(null)) // 컴파일 에러는 안 나지만 runtime 에러 발생 (NPE)
}

// 1.
fun startWithA1(str: String?): Boolean {
    if (str == null) {
        throw NullPointerException("str is null")
    }
    return str.startsWith("A")
}
fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A")?: throw NullPointerException("str is null")
}

fun startWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}
fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

// 2. null이 가능한 타입만을 위한 기능. Safe call, elvis
// Safe Call [ ? ]은 null이 아니면 실행하고, null이면 실행하지 않게 한다.
fun safeCall() {
    val str: String? = "ABC"
    // str.length // error
    println(str?.length) // 3

    val str2: String? = null
    println(str2?.length) // null
}

// Elvis 연산자 [:] 앞의 연산결과가 null이면 뒤의 값을 사용한다
fun elvis() {
    val str: String? = "ABC"
    str?.length ?: 0 // null이었을 경우 0이 사용된다
}
/*
Kotlin에서 함수의 파라미터 기본값을 지정할 때 ?: (엘비스 연산자)를 사용할 수는 없다.
?:는 런타임에서 null을 처리할 때 사용하는 연산자이고,
함수 선언 시 파라미터의 기본값을 지정하는 문법은 =을 사용해야 한다.
suspend fun <T: Any, R: Any> post(timeoutMillis: Long? ?: 5000) { ... }
?: 5000은 표현식 내부에서 null을 처리할 때 써야지,

함수 시그니처에서 기본값을 지정하는 문법으로는 쓸 수 없다.

 */

// early return
//fun calculate(number: Long?): Long {
//    number ?: return 0
//    // next logic
//}


// 3. nullable하지만 절대 null일수가 없는 값을 표시하는 방법 !!
fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A")
}
