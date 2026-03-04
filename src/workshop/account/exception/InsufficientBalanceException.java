package workshop.account.exception;

/*Account에 잔액(balance)이 부족할때 사용되는 사용자 정의 Exception 클라스*/
											//Exception 상속 받음
public class InsufficientBalanceException extends Exception{
	private int currentbalance;
	
	public InsufficientBalanceException(String errorMessage , int currentbalance) {
		//부모의 생성자를 불러 에러메세지 생성
		super(errorMessage);
		//변수로 지정해 현재 잔액이 얼마인지 같이 나타내도록
		this.currentbalance = currentbalance;		
	}
	public int getCurrentbalance() {
		//현재 잔액이 얼마인지 나타냄
		return currentbalance;
	}
}
