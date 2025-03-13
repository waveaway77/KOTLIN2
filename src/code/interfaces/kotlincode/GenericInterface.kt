package code.interfaces.kotlincode

class GenericInterface : GenericInterfaceImpl<Int, String> {
    override var key: Int = 0
    override var value: String = ""
}