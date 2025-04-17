package code.C_01_CompanionObject// https://velog.io/@yongin01/%EC%9E%90%EB%B0%94%EC%BD%94%ED%8B%80%EB%A6%B0-companion-object%EC%97%90-%EB%8C%80%ED%95%B4

class CompanionObject {
    var naverUrl = DataSourceClass.Datasource.baseUrl
    var daumUrl = DataSourceClass.baseUrl // 보다 보기 좋은 객체로의 접근!
}

class DataSourceClass {

    // object
    object Datasource {
        var baseUrl = "http://www.naver.com"
        fun printBaseUrl() {
            println("baseUrl is : $baseUrl")
        }
    }

    // companion
    companion object { // 익명으로, 클래스 내부 객체에 접근할 때 객체 이름을 반복할 필요가 없어졌다.
        var baseUrl = "http://www.daum.net"
        fun printBaseUrl() {
            println("baseUrl is : $baseUrl")
        }
    }
}