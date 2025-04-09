package code.C_22_Constructor

class Test {
    fun testMethod(): Test {
        return this
    }
}

class Test2(name:String, age:Int) {} // 기본생성자 추가
/*
자바코드
class Test2 {
    String name;
    int age;

    // 생성자
    public TestClass(String n1, int n2) {
            this.name = n1;
            this.age = n2;
    }
}
 */

// 멤버변수 초기화하는 코드
class Test3(name:String, age:Int) {
    val name: String = "kim"
    var age: Int = 1
    init {
        this.age = age // Test3.age = age
    }
}

// init 사용하지 않고 파라미터를 사용하는 코드
// 기본생성자의 매개변수 옆에 var과 val가 슬쩍 생긴것을 볼 수 있다.
// 얘네들을 붙혀주면 생성자의 매개변수를 클래스 내부에서 사용할 수 있다.
class Test4(var name:String, var age:Int) {
    fun introduce() {
        println("Hi I'm ${name} and ${age} years old.")
    }
}

class TestRestController(private val serviceFactory: Test) { // var을 붙이면 생성자의 매개변수를
    fun doSomething(): Test {
        return serviceFactory.testMethod() // 클래스내부에서도 쓸 수 있다
    }
}

class TestRestController2(serviceFactory: Test) { // var을 안 붙이면 생성자의 매개변수를
//    fun doSomething(): Test {
//        return serviceFactory.testMethod() // error! // 클래스내부에서 쓸 수 없음
//    }
}