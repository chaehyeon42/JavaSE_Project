package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		//Student 객체 생성
		Student student = new Student();
		
		//값 할당
		student.setName("김민수");
		student.setMajor("컴퓨터공학");
		
		try {
			student.setGrade(3); // 정상 입력
            System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
            
            System.out.println("5학년으로 변경");
            student.setGrade(5); // 예외 발생 지점
            
        } catch (InvalidGradeException e) {
            // 이미지의 Sample Run 결과와 동일하게 출력
            System.out.println(e.getMessage());
        }
	}
}
