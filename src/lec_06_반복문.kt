반복문
1. for-each
2. 전통적 for문
3. Progression과 Range
4. while문

----
1. for-each

java
for (long number:numbers)

kotlin
val numbers = listOf(1L, 2L, 3L)
for (number in numbers) {println(number} // Iterable이 구현된 타입이라면 가능

2. 전통for문
java
for (int i = 1; i <= 3; i++) {}
kotlin
for (i in 1..3) {println(i)}

java
i--의 경우
kotlin
for (i in 3 downTo 1) {}

jav
i+=2의 경우
kotlin
for ( i in 1..5 step 2) {}

3. Progression & Range

4.
kotlin
var i = 1
while (i <=3) {println(i) i++}