package code.interfaces.javacode;

// 터페이스를 implements한 클래스가 동일한 동작을 수행하도록 보장한다. 또 JAVA8 부터 디폴트 메소드를 허용하면서 추가요건에 대한 대처를 할 수 있도록 유연성을 확보해주었다
public interface Bank {

    //상수 (최대 고객에게 인출해 줄 수 있는 금액)
    public int MAX_INTEGER = 1000000000;

    //추상메서드 (인출)
    public abstract void withdraw(int amount);

    //추상메서드 (입금)
    public abstract void deposit(int amount);

    // default 메서드(고객의 휴면계좌 찾아주는 메서드)
    default String findCustomerAccount(String custId){
        System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
        System.out.println("**금융결제원에서 제공하는 로직**");
        return "00은행 000-000-0000-00";
    }
    // 만약 금결원의 요구로 새로운 개발 사안이 추가되고
    // 이 개발사안을 위한 새로운 추상메서드가 추가된다면 무슨 일이 벌어지는가?
    // 이를 implements한 모든 클래스에서 강제적으로 추상메서드를 구현해야하고 그러지 않을시 에러가 난다.
    // 이런 경우를 대비하여 default를 사용할 수 있는데,
    // 기본 구현부를 제공한 뒤 은행에서 각자 오버라이딩하여 바디를 다시 작성할 수 있는 것이다.
    // 이처럼 선택적으로 메서드를 가이드 할 수 있다.
    // 즉, 추가 요건으로 인해 불가피하게 반영을 해야할 때 디폴트메소드를 쓰면 효과적이다.

    // 정적 메소드(블록체인 인증을 요청하는 메소드)
    static void BCAuth(String bankName){
        System.out.println(bankName+" 에서 블록체인 인증을 요청합니다.");
        System.out.println("전 금융사 공통 블록체인 로직 수행");
    }

}
