package workshop.book.entity;

//출판물 속성을 그대로 상속받음.
//잡지
public class Magazine extends Publication{	
	private String publishingPeriod; //상속받은 속성이 아니라 Magazin만 가진 독자적 속성
	
	public Magazine() {
		
	}

	public Magazine(String title, String publishingDate, int page, int price, String publishingPeriod) {
		// 부모에 있는 변수를 가져오는 부모 생성자 -> super()
		super(title, publishingDate, page, price);
		this.publishingPeriod = publishingPeriod;
	}
	
	public String getPublishingPeriod() {
		return publishingPeriod;
	}
	
	public void setPublishingPeriod(String publishingPeriod) {
		this.publishingPeriod = publishingPeriod;
	}
	
}
