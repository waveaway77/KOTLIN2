package code.C_22_Constructor

class Constructor2 {
}

class Caterpillar() {
    fun eatApple() {
        println("yummy apple")
    }
}

class Apple(private val caterpillar: Caterpillar) {
    fun event() {
        caterpillar.eatApple()
    }
}
//---------------------------------------------------------
fun main() {
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1,"1")
    oldMap[1] = "MONDAY" // 1 : MONDAY
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

class MainController() {

}