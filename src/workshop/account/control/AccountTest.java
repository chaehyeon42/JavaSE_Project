package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {

	public static void main(String[] args) {
		//Account 객체 생성(Accountd의 생성자 (constructor)호출
		Account account = new Account();
		//생성한 Account 객체의 멤버변수의 값  할당
		//setter메서드 호출 하여 할당
		//고객번호 : “A1100”, 계좌번호 : “221-22-3477”, 잔액 : 100000
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
	
		System.out.println("고객번호 : " + account.getCustId());
		System.out.println("계좌번호 : " + account.getAcctId());
		System.out.println("잔액 :" + account.getBalance());
		
		try {
		//Overloaded 된 생성자 호출
		Account account2 = new Account("A1200","321-22-3477");
		account2.deposit(15000);
		account2.withdraw(10000);
		
		//Account의 부모 클래스인 Object 클래스의 toString() 메서드가 호출됨
		//workshop.account.entity.Account@2a139a55--> overriding 지정 하지 않으면 해당 결과가 나옴
		System.out.println(account2.toString());	
		
		//잔액부족
		account2.withdraw(10000);
	}catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage() + e.getCurrentbalance());
		}
	}
}
