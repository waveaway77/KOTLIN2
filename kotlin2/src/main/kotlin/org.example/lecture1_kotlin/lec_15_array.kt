package lecture

import com.fasterxml.jackson.databind.ObjectMapper

/*
1. 배열
2. 컬렉션
3.
---
1.
배열은 잘 사용하지 않는다
2.
컬렉션의 불변-가변 여부
불변컬렉션 List Set Map : referenceType의 element는 변경 가능하다.
가변컬렉션 MutableList MutableSet MutableMap : element를 추가삭제 가능
 */

// array
fun array() {
    val array = arrayOf(1,2,3,4,5)
    for (i in array.indices) {
        print("{$i : ${array[i]}}")
    }

    for ((idx, value) in array.withIndex()) {
        print("{$idx : $value}") // 1 : MONDAY
    }

    array.plus(6)

}

fun main() {
    val map2 = mutableMapOf<String, Any>()
    map2["hi"] = mapOf(
        "key" to "1",
        "key2" to "2",
    )

    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1,"1")
    oldMap[1] = "MONDAY" // 바로 값을 넣을 수 있다
    oldMap.put(0,"0")
    oldMap[0] = "0번을넣음"
    oldMap.put(-1,"ㅁㅁ")
    oldMap[-1] = "ㅁㅁ"
    for ((key, value) in oldMap.entries) {
        println("$key : $value")
    }
    /*
    1 : MONDAY
    0 : 0번을넣음
    -1 : ㅁㅁ
     */

    oldMap[1] ?: println("nothing is here") // 키값을 찾는다
}

// list
// J
// final List<Integer> numbers = Arrays.asList(0,1,2,3,4,5)
// K
fun list() {
    // 불변리스트 만들기
    val numbers = listOf(1,2,3,4,5)
    val emptyList = emptyList<Int>()
    printNums(emptyList()) // 타입추론이 가능하면 Int를 생략 가능하다
}

private fun printNums(numbers: List<Int>) {
}

fun getOne() {
    val numbers = listOf(1,2,3,4,5)
    val numbers2 = mutableListOf(1,2,3,4,5) // 가변타입
    numbers2.add(6)

    println(numbers[0])

    for (number in numbers) {
       println(number)
    }

    for ((index, value) in numbers.withIndex()) {
       println("$index : $value")
    }
}

// 불변 리스트 먼저 만들고 필요한 경우 가변 리스트를 만드는 게 좋다

// Collection 순서가 없고, 같은 element는 하나만 존재
// Map
fun map() {
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1,"1")
    oldMap[1] = "MONDAY"

    mapOf(1 to "Monday", 2 to "Tuesday")

    for (key in oldMap.keys) {
        println("$key : ${oldMap[key]}")
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println("$key : $value")
    }
}

// collection의 null가능성, java와 함께 사용하기
/*
List<Int?>
List<Int>?
List<Int?>?
 */

