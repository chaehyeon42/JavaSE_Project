package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
		// 멤버 변수
		private String studentId;
		private String name;
		private String major;
		private int grade;
				
		
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
		
		//학년은 1학년 ~ 4학년까지 4학년 이상일 시 메시지 호출
		public void setGrade(int grade) throws InvalidGradeException {
	        if (grade < 1 || grade > 4) {
	            throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
	        }
	        this.grade = grade;
	    }
		

}
