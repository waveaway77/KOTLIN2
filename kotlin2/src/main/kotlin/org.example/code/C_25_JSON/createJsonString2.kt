package org.example.org.example.code.C_25_JSON

import org.json.JSONArray
import org.json.JSONObject

// JSON을 클래스로 정의하고 직렬화하는 방식
/*
{
    "dataHeader": {},
    "dataBody": {
        "MAIN_MSG_INF_REPT_CN": "1",
        "ERRORLIST": [
            {
                "MSG_CD": "BAD",
                "MAIN_MSG_TXT": "동일상품 에러"
            }
        ],
        "ERRORCODE": "SYSCD01002",
        "ERROSRMSG": "전문 처리 중 에러"
    }
}
*/

fun createJsonString2(): String {
    val errorItem = JSONObject().apply {
        put("MSG_CD", "BAD")
        put("MAIN_MSG_TXT", "동일상품 에러")
    }

    val errorList = JSONArray().apply {
        put(errorItem)
    }

    val dataBody = JSONObject().apply {
        put("MAIN_MSG_INF_REPT_CN", "1")
        put("ERRORLIST", errorList)
        put("ERRORCODE", "SYSCD01002")
        put("ERRUSRMSG", "전문 처리 중 에러")
    }

    val response = JSONObject().apply {
        put("dataHeader", JSONObject())
        put("dataBody", dataBody)
    }

    return response.toString(4)
}
