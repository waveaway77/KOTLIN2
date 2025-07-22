package org.example.org.example.utils.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.example.org.example.code.C_25_JSON.jackson.objectMapper
import java.io.IOException


object JsonArrayToListConverter {


    @JvmStatic
    fun main(args: Array<String>) {
        val objectMapper = ObjectMapper()
        val jsonArrayString = "[{\"name\":\"Alice\",\"age\":30}, {\"name\":\"Bob\",\"age\":25}]"
        val jsonArrayString2 = "[{\"name\":\"Alice\",\"age\":30,\"address\":{\"street\":\"Horga\",\"city\":\"south dakota\"}}, {\"name\":\"Bob\",\"age\":25,\"address\":{\"street\":\"Horga\",\"city\":\"south dakota\"}}]"

        try {
            // JSON 배열 문자열을 List<YourClass>로 변환
            val yourList = objectMapper.readValue<List<YourClass>>(
                jsonArrayString2, objectMapper.typeFactory.constructCollectionType(
                    MutableList::class.java,
                    YourClass::class.java
                )
            )

            // 변환된 리스트 출력
            for (item in yourList) {
                println("${item.name}, ${item.age}, ${item.address}")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // 예시 클래스
    data class YourClass(
        var name: String? = null,
        var age: Int = 0,
        var address: Address? = null,

    )
    data class Address(
        var street: String? = null,
        var city: String? = null
    )
}