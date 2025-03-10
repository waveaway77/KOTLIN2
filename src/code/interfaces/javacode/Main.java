package code.interfaces.javacode;

public class Main {

    public static void main(String[] args) {

        Bank bank = new KBBank();
        bank.withdraw(1000);
        bank.deposit(1000);
        bank.findCustomerAccount("3933");

        // 인스턴스 교체

        bank = new SHBank();
        bank.withdraw(1000);
        bank.deposit(1000);
        bank.findCustomerAccount("3933");

//        bank = new KakaoBank(); implements 받지 않았으므로 호환 불가

    }
}
