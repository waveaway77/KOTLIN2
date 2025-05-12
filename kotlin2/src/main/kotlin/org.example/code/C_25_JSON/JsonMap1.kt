package org.example.org.example.code.C_25_JSON

import com.fasterxml.jackson.databind.ObjectMapper

fun main() {
    val newMap = mutableMapOf<String, Any>()
    newMap.put("A", "a")
    newMap.put("B", "b")
    println(newMap["A"]) // a

    val newList = mutableListOf<List<String>>()
    val innerList1 = mutableListOf<String>()
    innerList1.add("0")
    innerList1.add("1")
    innerList1.add("2")
    val innerList2 = mutableListOf<String>()
    innerList2.add("3")
    innerList2.add("4")
    innerList2.add("5")
    newList.add(innerList1)
    newList.add(innerList2)

    println(newList) // [[0, 1, 2], [3, 4, 5]]
    println(newList[1]) // [3, 4, 5]
    println(newList[1][1]) // 4


//    val jsonString = createJsonString()
//    val parsed = ObjectMapper().readValue(jsonString, Map::class.java) as Map<*, *>
//    val response = when (parsed) {
//        is Map<*, *> -> parsed["response"] as? Map<*, *>
//        else -> null
//    }
//
//    val dataBody = response?.get("dataBody") as? Map<*, *>
//    val errorList = dataBody?.get("ERRORLIST") as? List<*>
//    var errorList1 = errorList?.get(0) as? Map<* ,*>
//    var msgCd = errorList1?.get("MSG_CD")
//
//    println(msgCd) // BAD

    val jsonString = createJsonString()
    val parsed = ObjectMapper().readValue(jsonString, Map::class.java) as? Map<*, *> ?: return
    val response = parsed["response"] as? Map<*, *> ?: return
    val dataBody = response["dataBody"] as? Map<*, *> ?: return
    val errorList = dataBody["ERRORLIST"] as? List<*> ?: return
    val errorMap = errorList.firstOrNull() as? Map<*, *> ?: return
    val msgCd = errorMap["MSG_CD"]

    println(msgCd)

}

/*
{
    "rtncd": 5000,
    "rtnmsg": "다시 시도해주세요.",
    "response": {
        "dataHeader": {},
        "dataBody": {
            "MAIN_MSG_INF_REPT_CN": "1",
            "ERRORLIST": [
                {
                    "MSG_CD": "BAD1234",
                    "MAIN_MSG_TXT": "동일조건 에러"
                }
            ],
            "ERRORCODE": "SYSCD01002",
            "ERRUSRMSG": "전문 처리 중 에러"
        }
    },
    "requestUuid": "331bua"
}
*/