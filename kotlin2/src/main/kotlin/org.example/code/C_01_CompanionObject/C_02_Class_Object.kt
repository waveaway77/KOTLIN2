package org.example.org.example.code.C_01_CompanionObject

object Tree {
    fun grow() {}
}

class Grass {
    fun grow() {}
}

class Flower {
    companion object {
        fun grow() {}
    }
}

class Test() {
    fun test() {
        Tree.grow()
//        Grass.grow // error
        Flower.grow()
    }
}