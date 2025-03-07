// https://velog.io/@yongin01/%EC%9E%90%EB%B0%94%EC%BD%94%ED%8B%80%EB%A6%B0-companion-object%EC%97%90-%EB%8C%80%ED%95%B4

class CompanionObject {
    var naverUrl = DataSourceClass.Datasource.baseUrl
    var daumUrl = DataSourceClass.baseUrl // 보다 보기 좋은 객체로의 접근!
}

/*
object 키워드는 자바의 static과 new를 대신한다.
클래스 정보 적재와 객체 선언이 동시에 이루어진다.
 Datasource클래스를 정의함과 동시에 해당 인스턴스를 생성한다.
 Method Area, Heap Area에 동시에 정보를 적재한다는 뜻이다.
 */
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

    /*
    java bite코드 변환하여 확인해볼 때 object 키워드를 사용하면
    객체 내 static{}에서 new를 이용한 객체 생성과 변수 할당이 이루어진다.
    public final class DataSourceClass {
        public static final class Datasource {
            ...중략...
            static {
                DataSourceClass.Datasource var0 = new DataSourceClass.Datasource();
                INSTANCE = var0;
                baseUrl = "http://www.naver.com"
            }
        }
    }

    하지만 companion object를 사용하면...
    public final class DataSourceClass {
       public static final class Datasource {
          ...중략...
          public Datasource(DefaultConstructorMarker $constructor_marker) {
             this();
          }
       }
    }
     */
}