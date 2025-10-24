package org.example.org.example.utils.filtering

class FilteringUtils {
}

/*
all	모두 만족하면 true
any	하나라도 만족하면 true
none 하나도 만족하지 않으면 true
*/

// if문은 조건이 true 일 때 실행됨
fun main(args: Array<String>) {
    all() // all:전부있어야true !all:전부없어야true
    any() // any:하나라도있어야true !any:전부없어야true
    none() // none:하나도만족하지않아야true !none:하나라도있으면true
}

fun all() {
    val inputList_1 = listOf("AA", "BB", "CC")
    val targetList_1 = listOf("AA", "BB", "CC")

    // 타겟에 있는 게 인풋에도 "전부" 있는지 확인한다
    if (targetList_1.all { it in inputList_1 }) {
        println("타겟에 있는 게 인풋에도 전부 있어서 출력된 문장")
    }

    val inputList_2 = listOf("AA", "BB", "CC")
    val targetList_2 = listOf("")

    // 타겟에 있는 게 인풋에 전부 없는지 확인한다
    if (!targetList_2.all { it in inputList_2 }) { // 하나도 없는 거 '맞습니다' >> true >> 본문 실행
        println("타겟에 전혀 없어서 출력된 문장")
    }
}

fun any() {
    val inputList_1 = listOf("AA", "BB", "CC")
    val targetList_1 = listOf("AA")

    // 타겟에 인풋꺼가 하나라도 있는지 확인한다
    if (targetList_1.any { it in inputList_1 }) { // 있긴 있어요 >> true >> 실행
        println("타겟에 하나라도 있어서 출력")
    }

    val inputList_2 = listOf("AA", "BB", "CC")
    val targetList_2 = listOf("")
    // 타겟에 인풋꺼가 하나도 없을 때만 출력됨
    if (!targetList_2.any { it in inputList_2 }) { // 타겟에 인풋꺼가 하나도 없어요
        println("타겟에 인풋꺼가 하나도 없어서 실행되는 문장")
    }
}

fun none() {
    val inputList_1 = listOf("AA", "BB", "CC")
    val targetList_1 = listOf("")
    // 타겟에 인풋꺼가 하나도 없어야 true
    if (targetList_1.none { it in inputList_1 }) { // 하나도 없음 > true > 실행
        println("")
    }

    val inputList_2 = listOf("AA", "BB", "CC")
    val targetList_2 = listOf("AA")
    // 타겟에 인풋꺼가 하나라도 있으면 false
    if (targetList_2.none { it in inputList_2 }) {
        println("하나라도 있어서 이 문장은 실행안됨")
    } else {
        println("대신 이게 실행됨")
    }

    val inputList_3 = listOf("AA", "BB", "CC")
    val targetList_3 = listOf("AA", "BB", "CC")
    // 타겟에 인풋꺼가 하나라도 있으면 true
    if (!targetList_3.none { it in inputList_3 }) { // 전부 있음 > true > 실행
        println("전부 있어서 실행됨")
    }


    val inputList_4 = listOf("AA", "BB", "CC")
    val targetList_4 = listOf("AA")
    // 타겟에 인풋꺼가 하나라도 있으면 true이므로
    if (!targetList_4.none { it in inputList_4 }) {
        println("이 문장은 실행됨")
    }
}