data class PersonDto( // data가 붙으면 equals hashcode tostring을 다 만들어준당
    val name: String,
    val age: Int
)

fun handleCountry(country: Country) {
    when(country) {
        Country.KOREA -> println("kor")
        Country.AMERICA -> println("America")
    }
}

enum class Country(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US")
}

/*

Sealed class : 상속이 가능하도록 추상클래스를 만들기는 하지만 외부에서는 이 클래스를 상속 받지 못하게 하고 싶다. 이 경우 하위 클래스를 봉인한다. 컴파일 시에 하위 클래스의 타입을 모두 기억하므로 런타임 때 클래스 타입이 추가 될 수 없게 된다
- 하위 클래스는 같은 패키지 내에 있어야한다.
- Enum은 클래스를 상속 받을 수 없으나 SC는 상속이 가능하다
- Enum은 코드 한줄이 싱글톤으로 단일 인스턴스를 가지고 있으나 SC는 다른 클래스를 상속 받을 수도 있고 하위 클래스의 경우 멀티 인스턴스가 가능하다
*/

sealed class HyundaiCar(
    val name: String,
    val price: Int,
)