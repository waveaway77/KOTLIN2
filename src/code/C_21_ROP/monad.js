
// class Result<Error, Ok> {}
`많은 프로그래밍 언어에서 에러 상태가 되면 진행 중인 프로세스를 중단하고 함수 혹은 메소드를 호출한 caller에게 에러를 전달합니다.
그런데 함수를 호출한 caller에서는 어떤 에러가 발생했는지 알 수 없기 때문에
항상 unknown을 받고 unknown이 어떤 에러 타입인지에 따라 분기하려면
반드시 개발자가 해당 에러에 대해서 발생할 수 있음을 알고 있어야 합니다.`
function mustThrowError1() {
    throw new Error('This is a Error');
}

function main() {
    try {
        mustThrowError1();
        console.log('no reached');
    } catch (error) {
        error // is unknown
    }
}

`하지만 ROP Pattern에서는 에러 상태를 가지고 있을 경우 다음 프로세스가 실행되지 않고 넘어갑니다.`
function mustThrowError2() {
    return Result.failure(new Error('This is a Error'));
}

function main() {
    mustThrowError2(); // Result<Error, Ok>;
    console.log('reached'); // reached
}

`Functor는 값을 그 자체로 사용하지 않고 한꺼풀 감싼 것을 의미합니다.
직관적이게 "상자"라고 부르겠습니다.
왜 이런 형태가 필요할까요?
그건 값을 처리할지 말지에따라 값의 처리 여부를 달리 할 수 있기 때문입니다`

const arr = [value];
arr.map(value => `value is ${value}`); // [`value is ${value}`]
`.map은 Functor로 감싸여 있는 value를 꺼내 함수를 적용하고 다시 Functor로 감싸는 함수입니다.
이것을 통해서 >>값이 있을 경우<< 적절하게 처리할 수 있죠.`

`Promise 예제`
const promise: Promise<string> = Promise.resolve();
primise
    .then(value => `value is ${value}`)
    .catch(error => `no rechead`)

`flatMap 예제`
const arr2 = [value];
arr2.map(value => [`value is ${value}`]);
arr2.flatMap(value => [`value is ${value}`])