package code.interfaces.javacode;

public class KBBank implements Bank{
    @Override
    public void withdraw(int amount) {
        System.out.println("KB뱅크만의 인출 로직");
        if (amount < Bank.MAX_INTEGER) {
            System.out.println(amount + "원을 인출");
        } else {
            System.out.println(amount + "원 인출 실패");
        }
    }

    @Override
    public void deposit(int amount) {
        System.out.printf("KB은행만의 입금 로직 %d 원을 입금", amount);
    }
}
