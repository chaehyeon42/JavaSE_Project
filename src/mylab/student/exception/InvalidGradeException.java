package mylab.student.exception;

/**
 * 학년 값이 유효하지 않을 때(1~4 범위를 벗어날 때) 발생하는 사용자 정의 예외 클래스
 * Exception을 상속받았으므로 'Checked Exception'이 되어, 호출부에서 반드시 try-catch 처리가 필요함
 */
public class InvalidGradeException extends Exception{
	
	public InvalidGradeException(String errorMessage) {
		//부모의 생성자를 불러 에러메세지 생성
		super(errorMessage);	
	}
}

