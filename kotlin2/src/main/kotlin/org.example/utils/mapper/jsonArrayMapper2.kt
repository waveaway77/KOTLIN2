package org.example.org.example.utils.mapper

import org.example.org.example.code.C_25_JSON.jackson.objectMapper
import org.springframework.web.reactive.function.client.WebClient

class jsonArrayMapper2 {

    fun webClientPost(url: String, body: Any): String {
        return WebClient.create(url).post()
            .uri(url)
            .bodyValue(body)
            .retrieve()
            .bodyToMono(String::class.java)
            .block() ?: throw RuntimeException("Empty response")
    }

    // post안에서 제너릭 T를 사용하는 방법
    inline fun <reified T> post(url: String, body: Any): T {
        val responseBody = webClientPost(url, body)

        val javaType = objectMapper.typeFactory
            .constructType(T::class.java)
        return objectMapper.readValue(responseBody, javaType)
    }

    // List를 따로 처리하는 방법
    inline fun <reified T> postList(url: String, body: Any): List<T> {
        val responseBody = webClientPost(url, body)

        val javaType = objectMapper.typeFactory
            .constructCollectionType(List::class.java, T::class.java)

        return objectMapper.readValue(responseBody, javaType)
    }


}