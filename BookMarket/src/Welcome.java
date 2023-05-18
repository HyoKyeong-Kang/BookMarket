import java.util.Scanner;
import cartItem.CartItem;

public class Welcome {
	// 도서 개수 상수 선언
	static final int NUM_BOOK = 3;
	// 도서 정보 개수 상수 선언
	static final int NUM_ITEM = 5;

	// 도서를 담을 (장바구니) 배열 선언
	// 장바구니에 저장할수 있는 최대 항목 수를 제한 - 현재 있는도서 목록의 도서가 총 3개 뿐이니까 맞춰서 선언
	static CartItem[] mCartItem = new CartItem[NUM_BOOK];

	static int mCartCount = 0;

	public static void main(String[] args) {
		// 2차원 배열, 사용자가 장바구니에 추가하면 추가되는 곳
		String[][] mBook = new String[NUM_BOOK][NUM_ITEM]; // 도서 정보를 저장할 mBook 2차원 배열 생성
		BookList(mBook);

		Scanner sc = new Scanner(System.in);

		System.out.print("당신의 이름을 입력하세요 : ");
		String userName = sc.next();

		System.out.print("연락처를 입력하세요 : ");
		String userPhone = sc.next();

		while (true) {
			// 메뉴 출력 부분 메서드로 구현
			menuIntrodution();
			int num = sc.nextInt(); // 메뉴 번호 입력

			switch (num) {
			case 1:
				// 회원 정보 출력
				menuGuestInfo(userName, userPhone);
				break;
			case 2:
				// 장바구니 상품 목록 보기
				break;
			case 3:
				// 장바구니 비우기
				break;
			case 4:
				// 장바구니 항목 추가
				menuCartAddItem(mBook, sc);
				break;
			case 5:
				// 장바구니 항목 수량 줄이기
				break;
			case 6:
				// 장바구니 항목 삭제하기
				break;
			case 7:
				// 영수증 표시하기
				break;
			case 0:
				System.out.println("종료");
				return; // main() 메서드 종료

			default:
				System.out.println("0부터 7까지의 숫자만 입력하세요");
			}
		}

	}

	static void menuCartAddItem(String[][] mBook, Scanner sc) {
		// 1. 도서 목록 출력
		BookList(mBook); // 비어있는 2차원 배열인 mBook을 BookList() 메서드의 매개변수로 넘겨서 해당 정보들을 인덱스에 맞춰 저장

		
		//mBook 이 저장된 도서가 있는 상태
		while (true) {
			// 반복문을 이용하여 2차원 배열 mbook에 저장된 정보들을 출력
			BookInformation(mBook);

			// 2. 장바구니 목록 추가
			// 2-1 사용자에게 추가할 도서의 ISBN을 입력 받기
			System.out.print("추가할 도서의 ISBN을 입력하세요 : ");
			String str = sc.next(); // 사용자에게 입력받은 ISBN을 str 변수에 저장

//      boolean flag = false; // 장바구니 추가 if문에 사용될 변수 
			int numId = findBookIndexByISBN(str, mBook); // 해당 도서 정보 출력하기 위해 인덱스 번호를 저장

			// flag가 true일 때만 실행, 위의 if문이 실행된 경우에만 장바구니 추가 여부를 물음
			if (numId != -1) {
				// 장바구니 추가 여부를 묻기
				System.out.println("장바구니에 추가하시겠습니까? (Y|N)");
				str = sc.next(); // 사용자에게 입력받은 Y or N 값이 str 변수에 저장

				// 2-1.1 입력값이 Y이면 도서가 추가되었다는 메시지 출력
				if (str.equalsIgnoreCase("Y")) {
					// 사용자 입력값이 y, n인 소문자일 수도 있으니 항상 대문자로 변경 후 확인
					
					//장바구니 추가 메서드 
					/*
					 * mCartItem 도서가 있는지 없는지 확인 
					 * 1. 해당도서가 있으면 - 수량만 증가 
					 * 2. 해당도서가 없으면 - mCartItem[n] 도서 추가
					 */
					System.out.println(mBook[numId][1] + "가(이) 장바구니에 추가되었습니다.");

					// 2-1.2 입력값이 N이면 장바구니에 추가하지 않습니다라는 메시지 출력과 함께 해당 기능 자체 종료
				} else {
					System.out.println("장바구니에 추가하지 않습니다.");
					return;

				}
			} else {
				System.out.println("해당하는 도서가 없습니다.");
			}

		}

	}

	//도서 정보를 반복하는 메서드
	static void BookInformation(String[][] mBook) {
		for (int i = 0; i < NUM_BOOK; i++) {
			for (int j = 0; j < NUM_ITEM; j++) {
				System.out.print(mBook[i][j] + " | ");
			}

			System.out.println();
		}
	}

	static int findBookIndexByISBN(String str, String[][] mBook) {
		for (int i = 0; i < NUM_BOOK; i++) {
			if (str.equalsIgnoreCase(mBook[i][0])) {
//            flag = true; // 장바구니의 if문을 실행할 수 있게 true로 값 변경
				return i; // 도서가 존재할 경우 도서 인덱스 번호를 반환

			}
		}
		// 도서가 존재하지 않을 경우 -1
		return -1;
	}

	public static void BookList(String[][] book) {
		// 도서 정보를 저장하는 메서드
		book[0][0] = "ISBN1234";
		book[0][1] = "세이노의 가르침";
		book[0][2] = "6,480";
		book[0][3] = "세이노";
		book[0][4] = "자기계발";

		book[1][0] = "ISBN5678";
		book[1][1] = "던전앤파이터 진각성 아트북 세트";
		book[1][2] = "76,500";
		book[1][3] = "(주)네오플";
		book[1][4] = "일러스트집";

		book[2][0] = "ISBN9123";
		book[2][1] = "시장학개론";
		book[2][2] = "22,500";
		book[2][3] = "김승호";
		book[2][4] = "경제";

	}

	static void menuGuestInfo(String userName, String userPhone) {
		// TODO Auto-generated method stub
		System.out.println("-----접속하신 고객님의 정보는 -----");
		System.out.printf("이름 %s \t연락처 %s\n", userName, userPhone);
		System.out.println();
	}

	static void menuIntrodution() {
		System.out.println("****************************************");
		System.out.println("Welocme to Book Market!");
		System.out.println("****************************************");
		System.out.println("1. 고객 정보 확인하기 \t4. 장바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기 \t6. 장바구니에 항목 삭제하기");
		System.out.println("7. 영수증 표시하기 \t0. 종료");
		System.out.println("****************************************");
		System.out.println("메뉴 번호를 선택해주세요.");
	}

}
