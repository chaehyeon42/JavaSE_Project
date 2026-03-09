package workshop.animal.entity;

// spider는 animal을 상속 받음
public class Spider extends Animal{
	public Spider() {
		//animal에 기본 생성자가 없을때 super()로 지정, animal에 기본생성자가 있으면 super()가 자동으로 추가됨 
		//super() : 클래스에 부모생성자,기본생성자를 자동으로 호출 해줌
		//super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("Spider는 작은 벌레를 먹어요!!");		
	}
}
