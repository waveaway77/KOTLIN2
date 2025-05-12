package src;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// https://observerlife.tistory.com/98
/*
map
map()은 스트림의 각 요소를 변환하여 새로운 요소로 매핑하는 중간 연산입니다.
1:1 매핑이라고 생각하면 됩니다.
 */
// 클래스 안에 있는 모든 코드는 메서드나 초기화 블록 안에 있어야 하
class FlatMap2 {
    List<String> names = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");

    List<String> upperNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

    { // 인스턴스 초기화 블록
        System.out.println(upperNames); // [john, jane]
    }
}


/*
flatMap()은 스트림의 각 요소를 스트림으로 변환한 후, 모든 스트림을 하나의 스트림으로 평면화합니다.
1:N 매핑이라고 볼 수 있습니다.
 */
/*
map(): 각 요소를 변환한 스트림 반환
flatMap(): 각 요소를 변환한 스트림들을 하나의 스트림으로 평면화하여 반환
 */

class FlatMap3 {
    List<List<String>> nestesdLists = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("c", "d")
    );

    List<String> flatList = nestesdLists
            .stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    {
        System.out.println(flatList); // [a, b, c, d]
    }
}

/*
실전 예제
class Order {
    private List<Item> items;
    // 생성자, getter, setter 생략
}

class Item {
    private String name;
    private double price;
    // 생성자, getter, setter 생략
}

List<Order> orders = Arrays.asList(
        new Order(Arrays.asList(
            new Item("Apple", 1.0),
            new Item("Banana", 2.0)
        )),
        new Order(Arrays.asList(
            new Item("Orange", 3.0)
        ))
);

// 모든 주문에서 상품 이름만 추출
List<String> itemNames = orders
        .stream()
        .flatMap(order -> order.getItems().stream())
        .map(Item::getName)
        .collect(Collectors.toList());

public void main() {
    System.out.println(itemNames); // [Apple, Banana, Orange]
}
 */