import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Welcome {
	// 도서 갯수 상수 선언
	static final int NUM_BOOK = 3;
	// 도서 정보 갯수 상수 선언
	static final int NUM_ITEM = 5;
	static String[][] shoppingList = new String[NUM_BOOK][NUM_ITEM];
	static int shoppingListSize = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] mBook = new String[NUM_BOOK][NUM_ITEM];
		Scanner sc = new Scanner(System.in);

		System.out.println("당신의 이름을 입력하세요 : ");
		String userName = sc.next();

		System.out.println("연락처를 입력하세요 : ");
		String userPhone = sc.next();

		while (true) {
			menuIntrodution();
			int num = sc.nextInt(); // 메뉴번호 입력

			switch (num) {
			case 1:
				// 회원 정보입력
				menuGuestInfo(userName, userPhone);
				break;
			case 2:
				menuShowShoppingList();
				// 장바구니 상품목록 보기
				break;
			case 3:
				// 장바구니 비우기
				break;
			case 4:
				menuBookList(mBook);
				menuAddShoppingList(sc, mBook);
				// 장바구니에 항목 추가하기
				break;
			case 5:
				// 장바구니의 항목 수량 줄이기
				break;
			case 6:
				// 장바구니에 항목 삭제하기
				break;
			case 7:
				// 영수증 표시하기
				break;
			case 0:
				// 종료
				System.out.println("종료");
				return; // main 메서드 종료

			default:
				System.out.println("0부터 7까지의 숫자만 입력하세요");
			}
		}
	}

	
	
	static void menuAddShoppingList(Scanner sc, String[][] mBook) {

		boolean bookExists = false;
		String bookTitle = "";

		System.out.println("장바구니에 담을 도서의 ISBN을 입력하세요 : ");
		String addBook = sc.next();

		for (int i = 0; i < mBook.length; i++) {
			if (addBook.equals(mBook[i][0])) {
				bookExists = true;
				bookTitle = mBook[i][1];
				break;
			}
		}

		if (bookExists) {
	        boolean isAlreadyAdded = false;
	        for (int i = 0; i < shoppingListSize; i++) {
	            if (addBook.equals(shoppingList[i][0])) {
	                isAlreadyAdded = true;
	                break;
	            }
	        }
	        
	        if (isAlreadyAdded) {
	            System.out.println("이미 담긴 책입니다. 장바구니에 추가하시겠습니까? (Y/N)");
	        } else {
	            System.out.println("장바구니에 추가하시겠습니까? (Y/N)");
	        }
	        
	        String addCheck = sc.next().toUpperCase();
	            
	        if (addCheck.equals("Y")) {
	            System.out.println(bookTitle + " 가(이) 장바구니에 추가되었습니다.");
	            addToShoppingList(addBook, bookTitle);
	        } else {
	            System.out.println("장바구니에 추가하지 않습니다.");
	        }
	    } else {
	        System.out.println("유효하지 않은 ISBN입니다. 다시 입력해주세요.");
	        menuAddShoppingList(sc, mBook);
	    }
	}

	static void addToShoppingList(String isbn, String title) {
	    shoppingList[shoppingListSize][0] = isbn;
	    shoppingList[shoppingListSize][1] = title;
	    shoppingListSize++;
	}


	static void menuShowShoppingList() {
		System.out.println("장바구니 목록입니다.");

		for (int i = 0; i < shoppingList.length; i++) {
			if (shoppingList[i][0] != null) {
				System.out.println(shoppingList[i][0] + " | " + shoppingList[i][1]);
			}
		}
	}

	static void menuBookList(String[][] mBook) {
		// TODO Auto-generated method stub

		// 도서 정보 저장
		BookList(mBook);

		// 도서 정보 출력
		for (int i = 0; i < mBook.length; i++) {
			for (int j = 0; j < mBook[i].length; j++) {
				System.out.print(mBook[i][j] + " | ");
			}
			System.out.println();
		}

//	    System.out.println(Arrays.deepToString(bookArray)); // 한줄로 행과열 없이 출력 
		System.out.println();
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
