package lecture

import lecture.lec_17.Fruit

/*
1. 필터와 맵
2. 컬렉션 처리
3. List를 맵으로
4. 중첩된 맵 처리
 */

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


// 인자로 들어온 fruits에 filter를 적용하여 이름이 사과인 것만 apples에 저장된다.
val apples1 = fruits.filter { fruit -> fruit.name == "사과" }

// index정보도 필요한 경우
val apples2 = fruits.filterIndexed { idx, fruit ->
    println(idx)
    fruit.name == "사과"
}

// 사과 가격을 알고 싶은 경우
val apples3 = fruits.filter { fruit -> fruit.name == "사과" }
    .map {fruit -> fruit.price }

// map에서 인덱스가 필요한 경우
val apples4 = fruits.filter { fruit -> fruit.name == "사과" }
    .mapIndexed { idx, fruit ->
        println(idx)
        fruit.price
    }

// map의 결과가 null이 아닌것만 가져오고 싶다면
//val apples5 = fruits.filter { fruit -> fruit.name == "사과" }
//    .mapNotNull { fruit -> fruit.nullOrValue() }

// 2.
val isAllApple = fruits.all { fruit -> fruit.name == "사과" } // 조건을 모두 만족하면 true
val isNoApple = fruits.none { fruit -> fruit.name == "사과" } // 조건을 모두 불만족하면 true
val isNoApple2 = fruits.any { fruit -> fruit.price >= 10_000 } // 조건을 하나라도 만족하면 true
val fruitCount = fruits.count() // size와 동일
val fruitCount2 = fruits.sortedBy { fruit -> fruit.price } // 오름차순 정렬
val fruitCount3 = fruits.sortedByDescending { fruit -> fruit.price } // 내림차순 정렬
val distinctFruitName = fruits.distinctBy { fruit -> fruit.name } // name을 기준으로 중복을 제거한 뒤
    .map { fruit -> fruit.name } // 이름만 남음

var a = fruits.first() // null이 아니어야함
var b = fruits.lastOrNull()

// 3. List -> Map으로
// groupBy
val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
// associateBy

// 4.
// List<List<Fruit>>라면...
