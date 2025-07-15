package org.example.org.example.code.C_28_Map

class getValue {

    val insideMap = mapOf(
        "key1" to "value1",
        "key2" to "value2",
        "key3" to "value3",
    )

    val outsideMap = mapOf(
        insideMap to insideMap
    )

//    val value = outsideMap[insideMap["key1"]] as Map<*, *>

}