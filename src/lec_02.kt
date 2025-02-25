/*
1. how to check null in Kotlin
2. Safe Call, Elvis
3. 널 아님 단언하는 방법
4. platform type : 코틀린이 null 관련 정보를 알 수 없는 타입
*/

fun main() {
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
    str?.length // ok.

    val str2: String? = null
    println(str2?.length) // null이 나온다
}

// Elvis 연산자 : 앞의 연산결과가 null이면 뒤의 값을 사용한다
fun elvis() {
    val str: String? = "ABC"
    str?.length ?: 0 // null이었을 경우 0이 사용된다
}

// early return
//fun calculate(number: Long?): Long {
//    number ?: return 0
//    // next logic
//}


// 3. nullable하지만 절대 null일수가 없는 값을 표시하는 방법 !!
fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A")
}
