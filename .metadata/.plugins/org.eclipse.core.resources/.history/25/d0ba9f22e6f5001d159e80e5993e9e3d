package cartItem;

//장바구니는 도서 목록이 아니라 선택된 도서들의 항목을 담는 컨테이너
//실제로 선택란 도서들의 항목을 담는 곳이기 때문에 해당 도서에 대한 정보와 추가 정보를 나타내는 필드가 필요
//
//도서목록 = 모든 도서들의 집합 != (장바구니는 실제 선택된 도서들의 항목을 담아야 한다는것)
//
//1. 일차원 배열 - 각 요소들은 하나의 장바구니 항목을 나타냄
//2. 추가 정보(도서 ID(ISBN), 책이름, 수량, 총 가격)
//3. (일차원 배열) 각 요소들의 인덱스를 사용하여 특정 장바구니 항목에 접근하고 수정이 가능해야함
//4. 배열의 길이를 활용하여 장바구니에 저장된 항목의 개수를 파악해야함

public class CartItem {
	private String[] itemBook = new String[5];
	
	private String bookID; //ISBN
	private String bookName; //도서이름
	private int quantity; //수량
	private int totalPrice; //총 가격
	
	
	//기본생성자
	public CartItem() {
		super();
	}

	//일반 생성자 (추가 될 도서를 입력매개변수로 받음= 도사의 정보를 받는것)
	public CartItem(String[]book) {
		this.itemBook = book; //도서 항목(정보)
		this.bookID = book[0]; // 도서의 0번째 인덱스 = ISBN 값
		this.bookName = book[1]; //도서의 1번째 인덱스 = 도서 제목 값
		this.quantity = 1; //기본적으로 수량은 1로 설정
		updateTotalPrice();
		
	}

	public void updateTotalPrice() {
		// itemBook[2] - 도서의 가격 // this.quantity - 현재 수량
		// 총가격 = 도서의 가격 * 현재 수량
		this.totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity;
	}

	public String[] getItemBook() {
		return itemBook;
	}

	public void setItemBook(String[] itemBook) {
		this.itemBook = itemBook;
	}

	public int getQuantity() {
		return quantity;
	}
	
	//수량이 추가되는 경우라면 
	public void setQuantity(int quantity) {
		this.quantity = quantity; //수정된 수량 데이터로 교체
		this.updateTotalPrice(); // 총 합계 데이터를 수정하기 위해 합계 구하는 메서드 호출
	}

	public String getBookID() {
		return bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [bookID=" + bookID + ", bookName=" + bookName + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
	
	
}
