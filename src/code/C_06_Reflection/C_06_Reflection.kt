package code.C_06_Reflection

import kotlin.reflect.KClass

class C_06_Reflection {
}

/*
리플렉션 reflection
클래스를 생성자로 전달하면
해당 클래스를 기반으로 동적으로 객체를 생성하거나
필드, 메서드를 조회하는 등 리플렉션을 사용할 수 있다.
 */
class InstanceCreator<T : Any>(private val clazz: KClass<T>) {
    fun createInstance(): T {
        return clazz.constructors.first().call()
    }
}

class MyClass

fun main() {
    val creator = InstanceCreator(MyClass::class) // 클래스명::class 형태로 KClass 객체를 가져올 수 있다.
    val instance = creator.createInstance()
    println(instance::class.simpleName) // MyClass
}