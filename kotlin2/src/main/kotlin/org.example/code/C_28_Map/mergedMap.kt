package org.example.org.example.code.C_28_Map

fun main() {
    val map1 = mapOf(
        "key1" to "value1",
        "key2" to "value2",
        "key3" to "value3",
    )

    val map2 = mapOf(
        "a" to 1,
        "b" to 2,
        "c" to 3,
    )

    val mergedMap = map1 + map2

    println(mergedMap) // {key1=value1, key2=value2, key3=value3, a=1, b=2, c=3}
}