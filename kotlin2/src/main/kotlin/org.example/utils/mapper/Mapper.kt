package org.example.org.example.utils.mapper

import com.fasterxml.jackson.databind.ObjectMapper

fun main() {

    val response = Any::class.java
    val fromResponse = FromResponse("hi")

    val objectMapper = ObjectMapper()
    val convertedResponse1 = objectMapper.convertValue(response, ToResponse::class.java)
    val convertedResponse2 = objectMapper.convertValue(fromResponse, ToResponse::class.java)

    println(convertedResponse1.dummyName) // java.lang.Object
    println(convertedResponse2.dummyName) // hi
}

data class FromResponse(
    val dummyName: String
)

data class ToResponse(
    val dummyName: String
)