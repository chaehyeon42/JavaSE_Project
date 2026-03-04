package workshop.person.control;

import workshop.person.entity.PersonEntity;

public class PersonEntityTest {
	public static void main(String[] args) {
		PersonEntityTest test= new PersonEntityTest();
		//Array 사이즈가 2개인 배열 선언
		PersonEntity[] persons = new PersonEntity[2];
		
		test.fillPersons(persons);		
		test.printPersons(persons);
	}

	public void printPersons(PersonEntity[] persons) {
		//enhanced for loop
		for (PersonEntity person : persons) {
			System.out.println(person.getName() + " " + person.getGender());
		}
	}

	public void fillPersons(PersonEntity[] persons) {
		//persons[0] 의 타입은 PersonEntity 타입
		persons[0] = new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
		persons[1] = new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
	}
}
