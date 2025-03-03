코틀린의 예외
1. try catch finally
2. checked Exception & unchecked Exception
3. try with resources

Buffer예제
---

1.
java
try { return Integer.parseInt(str)} catch(NumberFormatException e) {throw new Illegal~}
kotlin
try {
    return str.toInt() // 기본타입간의 형변환은 to~를 사용함
} catch (e: NumberformatExcetpion) {
    throw Ille~ // new를 사용하지 않음
}

java
return try {} catch() {return null}
try {} catch (e:Numberforamtexetpion) {
    null
}

2.
kotlin에는 throws를 반드시 적어줘야하는 java와 다르게 throws를 지정해주지 않아도된다. 모두 unchecked exception이기 때문

3.
kotlin에는 try with resources가 없고 .use를 사용한다