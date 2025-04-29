package org.example.org.example.code.C

class Content(val content: ContentData) { // 2. content 데이타를 받아온다.

    data class ContentData( // 1. Content 클래스의 멤버변수
        val data1: String = "unknown", // 초기값을 지정한다
    )

    fun printObject() { // 3. content 데이타를 출력한다.
        Print.print(
            content.data1
        )
    }

}

object Print { // data를 받아와서 출력하는 Print 클래스
    fun print(
        data1: String,
    ) {
        println(data1)
    }
}

fun main() {
    // 생성자로 값을 넣는 방법
    Content.ContentData(
        data1 = "real data",
    )

    println(Content.ContentData().data1)
/*
    // set으로(?) 값을 넣는 방법 >> var로 써야하므로 적절하지 못함
    fun test() {
        val mainContent = Content.ContentData()
        mainContent.data1 = "real data" // error // var로 변경
    }
*/

}