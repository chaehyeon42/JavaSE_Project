package workshop.book.entity;

//참고(조)서
public class ReferenceBook extends Publication {
	// 상속받은 속성이 아니라 ReferenceBook만 가진 독자적 속성
	private String field;
	
	public ReferenceBook() {
		
	}

	public ReferenceBook(String title, String publishingDate, int page, int price, String field ) {
		super(title, publishingDate, page, price);
		this.field = field;
	}

	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
}
