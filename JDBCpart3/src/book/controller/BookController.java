package book.controller;

import java.util.ArrayList;

import book.model.service.BookService;
import book.model.vo.Book;
import book.view.BookMenu;

public class BookController {
	BookMenu bm = new BookMenu();
	
	public void selectAll() {
		BookService bs = new BookService();
	
		ArrayList<Book> list = bs.selectAllBooks();
		
		if(list.isEmpty()) { // ★★★★★ ==null로 비교하면 안됨
			System.out.println("검색 되는 도서가 없습니다.");
		}else {
			bm.displayBookTitle(list);
		}
		
	}

	public void insertBook(Book b) {
		BookService bs = new BookService();
		
		int result = bs.insertBook(b);
		
		if(result>0) {
			System.out.println("도서 정보 입력 완료");
		}else {
			bm.displayError("insert");
		}
		
	}

	public void searchBook(int bid) {
		BookService bs = new BookService();
		Book b = bs.selectBook(bid);
		if(b == null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			bm.displayBookTitle(b);
		}
		
	}

	public void deleteBook(int bid) {
		BookService bs = new BookService();
		
		int result = bs.deleteBook(bid);
		if(result > 0) {
			System.out.println("도서 정보 삭제 완료");
		}else {
			bm.displayError("delete");
		}
		
	}

	public void updateBook(int bid, Book b) {
		BookService bs = new BookService();
		
		b.setBid(bid);
		
		int result = bs.updateBook(b);
		if(result > 0) {
			System.out.println("도서 정보 수정 완료");
		}else {
			bm.displayError("update");
		}
		
	}

	public void searchBookTitle(String title) {
		BookService bs = new BookService();
		
		ArrayList<Book> list = bs.searchBookTitle(title);	
		// 1. 같은 이름 책이 여러권 있을 수 있다.(ArrayList)
		// 2. 쿼리에서 like로 검색되게 하면 책이 여러권 나올 수 있다.(ex : c라고 검색하면 c로 시작하는 책이름 다 해당)

		if(list.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			bm.displayTitle(list);
		}
	}

}






