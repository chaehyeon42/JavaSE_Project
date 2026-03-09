package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		//Student 객체 생성(기본 생성자 호출)
		Student student = new Student();
		
		//Setter 메서드를 이용한 데이터 할당 (캡슐화 준수)
		student.setName("김민수");
		student.setMajor("컴퓨터공학");
		
		try {
			student.setGrade(3); // 정상적인 범위의 학년 설정
            System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
            
            System.out.println("5학년으로 변경");
            
            // 예외 발생 지점: 비즈니스 로직상 유효하지 않은 값(5학년) 입력 시도
            //Student 클래스의 setGrade 메서드 내부에서 'throw new InvalidGradeException(...)'이 실행됨
            student.setGrade(5); 
            
        } catch (InvalidGradeException e) {
        	//예외 처리
        	// 사용자 정의 예외 클래스에 담긴 에러 메시지를 출력하여 프로그램 중단을 방지
            System.out.println(e.getMessage());
        }
	}
}
