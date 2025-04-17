package code.interfaces.kotlincode

interface Animal {
    fun makeSound()
}

class Dog : Animal { // Animal 타입으로 다룰 수 있다.
    override fun makeSound() {
        println("Woof")
    }
}

class Cat : Animal { // Animal 타입으로 다룰 수 있다.
    override fun makeSound() {
        println("Meow")
    }
}

fun main() {
    val animals: List<Animal> = listOf(Dog(), Cat())
    animals.forEach { it.makeSound() } // Woof Meow
}