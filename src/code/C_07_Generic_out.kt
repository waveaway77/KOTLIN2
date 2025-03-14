package code

import com.sun.tools.javac.jvm.Items

class C_07_Generic_out

class Box<T>(val items: Items) // 값을 넣고 뺄 수 있다.
class ReadOnlyBox<out T>(val items: T) { // 값을 넣을 수 없다
    fun getItem(): T = items // 값을 꺼내는 건 가능하다
}

