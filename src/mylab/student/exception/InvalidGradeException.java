package mylab.student.exception;

public class InvalidGradeException extends Exception{
	
	public InvalidGradeException(String errorMessage) {
		//부모의 생성자를 불러 에러메세지 생성
		super(errorMessage);	
	}
}

