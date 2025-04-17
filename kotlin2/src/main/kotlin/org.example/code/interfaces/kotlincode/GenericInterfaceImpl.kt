package code.interfaces.kotlincode

interface GenericInterfaceImpl<K, V> { // 타입의 직접 할당이 반드시 이루어져야한다.
    var key: K
    var value: V
}