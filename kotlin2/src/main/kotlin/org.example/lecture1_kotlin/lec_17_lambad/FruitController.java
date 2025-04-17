package org.example.lecture1_kotlin.lec_17_lambad;

import lecture.lec_17_lambad.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FruitController {

    // 과일가게 과일의 옵션
    List<lecture.lec_17_lambad.Fruit> fruits = Arrays.asList(
            new lecture.lec_17_lambad.Fruit("사과", 1_000),
            new lecture.lec_17_lambad.Fruit("사과", 1_200),
            new lecture.lec_17_lambad.Fruit("사과", 1_200),
            new lecture.lec_17_lambad.Fruit("사과", 1_500),
            new lecture.lec_17_lambad.Fruit("바나나", 3_000),
            new lecture.lec_17_lambad.Fruit("바나나", 3_200),
            new lecture.lec_17_lambad.Fruit("바나나", 2_500),
            new lecture.lec_17_lambad.Fruit("수박", 10_000)
    );

    // 사과만 보여달라는 요청
    private List<lecture.lec_17_lambad.Fruit> findApples(List<lecture.lec_17_lambad.Fruit> fruits) {
        List<lecture.lec_17_lambad.Fruit> apples = new ArrayList<>();
        for (lecture.lec_17_lambad.Fruit fruit : fruits) {
            if (fruit.getName().equals("사과")) {
                apples.add(fruit);
            }
        }
        return apples;
    }

    // 바나나만 보여달라는 요청
    private List<lecture.lec_17_lambad.Fruit> findBananas(List<lecture.lec_17_lambad.Fruit> fruits) {
        List<lecture.lec_17_lambad.Fruit> apples = new ArrayList<>();
        for (lecture.lec_17_lambad.Fruit fruit : fruits) {
            if (fruit.getName().equals("바나나")) {
                apples.add(fruit);
            }
        }
        return apples;
    }

    // 중복되므로 코드를 변환
    // name을 인자로 받는다
    private List<lecture.lec_17_lambad.Fruit> findFruitsWithName(List<lecture.lec_17_lambad.Fruit> fruits, String name) {
        List<lecture.lec_17_lambad.Fruit> apples = new ArrayList<>();
        for (lecture.lec_17_lambad.Fruit fruit : fruits) {
            if (fruit.getName().equals(name)) {
                apples.add(fruit);
            }
        }
        return apples;
    }

    // 그런데 만약 요청이 계속 추가된다면 어떻게 해야할까?
    // 사과랑 바나나 같이 보여달라, 1200원 미만의 사과만 보여달라 등...
    // 이러면 파라미터를 늘리는 것만으로는 해결이 안 되므로 인터페이스와 익명 클래스를 사용하게 된다
    // 엥 여기서부터 놓침
    private List<lecture.lec_17_lambad.Fruit> filterFruits(List<lecture.lec_17_lambad.Fruit> fruits, FruitFilter fruitFilter) {
        List<lecture.lec_17_lambad.Fruit> results = new ArrayList<>();
        for (lecture.lec_17_lambad.Fruit fruit : fruits) {
            if (fruitFilter.isSelected(fruit)) {
                results.add(fruit);
            }
        }
        return results;
    }

    // Stream
    private static  List<lecture.lec_17_lambad.Fruit> filterFruits(List<lecture.lec_17_lambad.Fruit> fruits, Predicate<Fruit> fruitFilter) {
        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }

}
