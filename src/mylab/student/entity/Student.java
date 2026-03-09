package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;


//학생 정보를 관리하는 Entity 클래스
public class Student {
		// 멤버 변수 : 외부에서 직접 접근하지 못하도록 private으로 선언 (캡슐화) 
		private String studentId;
		private String name;
		private String major;
		private int grade;
		
		//getter&setter
		// 외부에서 private 변수에 안전하게 접근하거나 값을 수정하기 위해 사용
		public String getStudentId() {
			return studentId;
		}
		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		public int getGrade() {
			return grade;
		}
		
		//학년 설정 메서드 (비즈니스 로직 포함)
		//학년은 1학년 ~ 4학년까지 4학년 이상일 시 메시지 호출
		//@throws InvalidGradeException 범위를 벗어날 경우 발생하는 사용자 정의 예외
		
		public void setGrade(int grade) throws InvalidGradeException {
	       //유효성 검사 (Validation): 데이터의 무결성을 유지하는 핵심 로직
			if (grade < 1 || grade > 4) {
	            throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
	        }
	        this.grade = grade;
	    }
		

}
