package org.example.org.example.code.C_25_JSON

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.example.org.example.code.C_25_JSON.jackson.objectMapper


fun main() {

    val userRequest = UserRequest(
        dataHeader = emptyMap(),
        dataBody = UserDataBody(
            userNo = "1",
            status = "10"
        )
    )

    println(userRequest) // UserRequest(dataHeader={}, dataBody=UserDataBody(userNo=1, status=10))
    println(objectToMap(userRequest)) // {dataHeader={}, dataBody={userNo=1, status=10}}

}

object jackson {
    val objectMapper: ObjectMapper = jacksonObjectMapper()
}

fun objectToMap(obj: Any): Map<String, Any?> {
    return try {
        @Suppress("UNCHECKED_CAST")
        objectMapper.convertValue(obj, Map::class.java) as Map<String, Any?>
    } catch (e: Exception) {
        mapOf("value" to obj.toString())
    }
}

data class UserRequest(
    val dataHeader: Map<String, String>,
    val dataBody: UserDataBody
)
data class UserDataBody(
    val userNo: String = "",
    val status: String = ""
)