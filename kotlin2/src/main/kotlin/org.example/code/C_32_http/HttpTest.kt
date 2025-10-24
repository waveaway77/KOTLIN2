package org.example.org.example.code.C_32_http

import org.springframework.web.reactive.function.client.WebClient
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import reactor.netty.http.client.HttpClient
import reactor.netty.transport.logging.AdvancedByteBufFormat

fun main() {
    // Reactor Netty HttpClient 생성 + wiretap 활성화 (네트워크 이벤트 로그 출력)
    val httpClient = HttpClient.create()
        .wiretap("reactor.netty.http.client.HttpClient",
            io.netty.handler.logging.LogLevel.DEBUG,
            AdvancedByteBufFormat.TEXTUAL)

    // WebClient 생성 (ReactorClientHttpConnector에 httpClient 주입)
    val webClient = WebClient.builder()
        .baseUrl("https://httpbin.org")
        .clientConnector(ReactorClientHttpConnector(httpClient))
        .build()

    // 요청 실행 (실제 connect()가 이 시점에 발생)
    val responseMono = webClient.get()
        .uri("/get")
        .retrieve()
        .bodyToMono(String::class.java)

    // 구독(subscribe) → Netty가 connect() 실행
    responseMono.block().also { println("Response: $it") }
}