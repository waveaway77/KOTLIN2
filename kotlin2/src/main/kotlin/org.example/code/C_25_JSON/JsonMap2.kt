package org.example.org.example.code.C_25_JSON

import com.fasterxml.jackson.databind.ObjectMapper

fun main() {
    val jsonString2 = createJsonString2()
    val jsonMap = ObjectMapper().readValue(jsonString2, Map::class.java) as? Map<*, *> ?: return

    val dataBody = when (jsonMap) {
        is Map<*, *> -> jsonMap["dataBody"] as? Map<*, *>
        else -> null
    }

    val errorList = dataBody?.get("ERRORLIST") as List<*>
    // 컴파일러는 null 가능성이 있으면 get() 호출을 막는다.
    // NPE 발생이 가능하기 때문.
    // dataBody가 null이면 → 전체 결과는 null이된다.
    val msgCd = errorList[0] as? String

    // "BAD라는 메시지 코드가 포함된 에러는 멱등 처리로 간주하겠다
    // 예를 들어, 어떤 요청이 실패했는데 실패 사유가 "BAD"라는 코드라면,
    // 이건 재요청해도 같은 에러가 나고,
    // 서버 상태를 변경하지 않으므로,
    // 멱등하게 안전하게 retry할 수 있다고 판단한 것임.
    val isIdempotent = errorList?.any { errorItem -> // null이 아니면 실행한다 [ ?. ] // any { ... }는 리스트 중 하나라도 조건을 만족하면 true를 반환함.
        // val isNoApple2 = fruits.any { fruit -> fruit.price >= 10_000 } // 조건을 하나라도 만족하면 true
        when (errorItem) {
            is Map<*, *> -> errorItem["MSG_CD"] == "BAD"
            // 리스트 항목인 errorItem이 Map<*, *> 타입인 경우에만 처리.
            else -> false
        }
    } ?: false
    // any { ... } 자체 결과가 null일 수 있으므로
    // 앞의 연산결과가 null이면 뒤의 값을 사용한다
}

// 멱등성
//적용 사례
//프론트엔드/모바일: 사용자 요청이 실패한 것처럼 보여서 retry를 누를 수 있음 (멱등성을 활용한 예)
//API Gateway: 같은 요청이 여러 번 들어오면 중복 처리 막기 위해 idempotency key 사용 (멱등성을 지키기 위한 방법 중 하나)
//결제 시스템: 같은 결제가 중복으로 처리되지 않도록 안전 장치 필요 (멱등성을 유지해야함)

