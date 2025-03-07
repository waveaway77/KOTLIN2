package lecture.lec_17/*
1. java에서 람다를 다루기 위한 노력
2. 코틀린에서의 람다
3. 코틀린의 Closure
4. try with resources
*/

// 1.
fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    )

    // 람다직접호출1
    // 함수의 타입: (파라미터타입) -> 반환타입 // isApple의 타입은 "Fruit을 받아 Boolean으로 반환하는 것"
    var isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean { // 익명함수==람다
        return fruit.name == "사과"
    }

    // 람다직접호출2
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[0])

    // 함수의 타입이 같으므로 함수 자체를 인자로 보낼 수 있다.
    filterFruits(fruits, isApple)
    // isApple을 직접 쓰지 않고 바로 넣어줄 수도 있다.
    filterFruits(fruits, fun(fruit: Fruit): Boolean { return fruit.name == "사과" }) // isApple을 대치한것
    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" }) // isApple2를 대치한것
    // 함수가 파라미터 여러개 중 마지막 인자일 경우 소괄호 밖으로 뺄수도 있다.
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    filterFruits(fruits) { a -> a.name == "사과" }
    filterFruits(fruits) { it.name == "사과" } // 한개만 들어올경우 it이라고 할 수도 있어요

}

// 함수용 interface를 사용하지 않음
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

// 3. Closure
