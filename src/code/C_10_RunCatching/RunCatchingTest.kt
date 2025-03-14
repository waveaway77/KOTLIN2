package code.C_10_RunCatching

class RunCatchingTest {
    // https://velog.io/@ekxk1234/%EC%BD%94%ED%8B%80%EB%A6%B0-%EA%B3%A0%EA%B8%89-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC
}

fun getStr() : Nothing = throw Exception("예외 발생 기본 값으로 초기화")

/* try catch */
fun do1() {
    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본값"
    }
    println(result) // 예외 발생 기본 값으로 초기화 // 기본값
}

/* RunCatching */
fun do2() {
    val result2 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"
        }
    println(result2) // 예외 발생 기본 값으로 초기화 // 기본값
}

/*
.getOrNull() : 실패인 경우 null을 반환
.exceptionOrNull() : 성공인 경우 null 반환, 실패인 경우 throwable반환
.getOrDefault() : 성공인 경우 성공 값 반환, 실패시 지정한 기본값 반환
.getOrElse :
.getOrThrow : 성공시엔 값 반환, 실패시엔 예외 발생
 */

/* map : 성공인 경우 원하는 값으로 변경한다 */
fun do3() {
    val result3 = runCatching { "안녕" }
        .map {
            it + "하세요"
        }.getOrThrow()
    println(result3) // 안녕하세요
}
// 만약 맵으로 처리 중에 예외가 발생한 경우
fun do4() {
    val result4 = runCatching { "안녕" }
        .map {
            getStr()
        }.getOrDefault("기본값")
    println(result4) // Exception in thread "main" java.lang.Exception:
}

/* mapCatching : 성공한 경우 맵핑, 예외 발생 시 재처리 */
fun do5() {
    val result5 = runCatching { "안녕" }
        .mapCatching { getStr() }
        .getOrDefault("기본값")
    println(result5) // 기본값
}
