package code.interfaces;

public class SHBank implements Bank{

    @Override
    public void withdraw(int amount) {
        System.out.println("SH뱅크만의 인출 로직");
        if (amount < Bank.MAX_INTEGER) {
            System.out.println(amount + "원을 인출");
        } else {
            System.out.println(amount + "원 인출 실패");
        }
    }

    @Override
    public void deposit(int amount) {
        System.out.printf("SH은행만의 입금 로직 %d 원을 입금", amount);
    }

    // default 메서드 구현
    @Override
    public String findCustomerAccount(String custId){
        System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
        System.out.println("**SH은행만의 로직 적용**");
        custId = custId.substring(0, 2);
        return "00은행 000-000-0000-00";
    }

}
