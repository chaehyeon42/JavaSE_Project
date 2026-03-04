package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	//멤버변수
	private String custId;
	private String acctId;
	private int balance;
	
	//Default Constructor 생성자
	public Account() {
		System.out.println(this.getClass().getName() + "기본생성자 호출됨");
	}
	
	//Constructor Overloading(중복제외)
	public Account(String custId, String acctId) {
		setCustId(custId); //기존에 있는 코드가 있을땐 set 메서드 호출로 작성 해도 됨
		setAcctId(acctId);
		//this.custId = custId;
		//this.acctId = acctId;
	}
	
	//멤버 변수 값을 변경 하는 메서드 (Setter method)
	
	/*
	 * public void setBalance(int balance) { //멤버 변수를 지칭 할때는 앞에 this. 사용
	 * this.balance = balance; }
	 */
		
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	//멤버 변수 값을 조회하는 메서드(Getter method)
	public int getBalance() {
		return balance;
	}
	
	public String getCustId() {
		return custId;
	}
	
	public String getAcctId() {
		return acctId;
	}
	
	//입금
	public void deposit(int amount) {
		//this.balance = this.balance + amount;
		//위 구문 축약 버전
		this.balance += amount;
	}
	
	//출금                                                           //잔액 부족시 메시지 호출 
	//AccountTest 에서 try/catch 를 하도록 위임
	public void withdraw(int amount) throws InsufficientBalanceException{
		if(amount > balance) {
			//Exception을 강제로 발생 시킴
			throw new InsufficientBalanceException("잔액부족. 현재잔액은 = ", balance);
		}
		this.balance -= amount;
	}
	
	//메서드 재정의(Overriding)	- 부모 클래스의 메서드 선언 부분은 같아야하고 구현만 다름(오버라이드 특징)	
	@Override
	public String toString() {
		return "Account [고객번호=" + custId + ", 계좌번호=" + acctId + 
				", 잔액=" + balance + "]";
	}
		
}
	
