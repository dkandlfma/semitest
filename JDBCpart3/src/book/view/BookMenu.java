package book.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.controller.BookController;
import book.model.vo.Book;

public class BookMenu {

	public void displayMenu() {

		Scanner sc = new Scanner(System.in);
		BookController bc = new BookController();
		
		do {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회");
			System.out.println("6. 도서 목록 전체 조회");
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1: bc.insertBook(inputBook()); break;
				case 2: bc.updateBook(inputBookId(),inputBook()); break;
				case 3: bc.deleteBook(inputBookId());break;
				case 4: bc.searchBook(inputBookId()); break;
				case 5: bc.searchBookTitle(inputTitle()); break;
				case 6: bc.selectAll(); break;
				case 9: System.out.println("프로그램을 종료합니다.");return;
				default : System.out.println("번호를 잘못 누르셨습니다.");
			}
		}while(true);
		
	}
	private String inputTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 도서명 입력 : ");
		String title = sc.nextLine();
		
		return title;
	}
	private int inputBookId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 번호 입력 : ");
		int bId = sc.nextInt();
		
		return bId;
	}

	private Book inputBook() {
		Scanner sc = new Scanner(System.in);
		
		Book b = null;
		System.out.println("추가 할 도서에 대한 정보를 입력하세요");
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		System.out.print("출판사 : ");
		String pub = sc.nextLine();
		System.out.print("출판날짜(20000101형식으로 입력) : ");
		String pubDate = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();	// 엔터 제거
		
		b = new Book(title, author, pub, pubDate, price);

		return b;
	}

	public void displayBookTitle(ArrayList<Book> list) {
		// 단순 for문
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		// for-each문
//		for(Book b : list) {
//			System.out.println(b);
//		}
		// 그냥 냅다 출력
//		System.out.println(list);
		
	}

	public void displayError(String string) {
		switch(string) {
			case "insert" : System.out.println("도서정보 입력 실패!"); break;
			case "delete" : System.out.println("도서정보 삭제 실패!"); break;
			case "update" : System.out.println("도서정보 수정 실패!"); break;
			default : System.out.println("알 수 없는 에러 발생");
		}
		
	}

	public void displayBookTitle(Book b) {
		System.out.println(b);
	}
	public void displayTitle(ArrayList<Book> list) {
		
		for(int i = 0 ; i< list.size(); i++) {
		System.out.println(list.get(i));
		}
		
	}
	
	
	
	

}
