package com.yedam.java.home;

import java.util.ArrayList;
import java.util.List;

// DAO 데이터베이스의 접근 담당하는 클래스 ( DB에 CRUD 전담 -> 조회 및 조작 ) / 주로 싱글톤으로 작성하는게 보편적
// JSP 와 Servlet 은 따로 구현.
public class BookRepo implements BookAccess {
	// 필드
	private static BookRepo instance = new BookRepo();
	private List<Book> bookList = new ArrayList<>();
	
	// 생성자
	private BookRepo() { }
	
	// 메소드
	public static BookRepo getInstance() {
		return instance;
	}

	@Override
	public void insertBook(Book book) {
		if(bookList.add(book))
			System.out.println("도서 등록이 완료되었습니다.");
		else
			System.out.println("도서 등록이 실패하였습니다.");
		
		System.out.println();
	}

	@Override
	public Book[] selectBooks() {
		Book[] books = bookList.toArray(new Book[bookList.size()]);
		return books;
	}

	@Override
	public Book selectBook(int isbn) {
		Book book=null;
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getIsbn()==isbn)
				book=bookList.get(i);
		}
		return book;
	}

	@Override
	// Report 출력 메소드
	public void selectRepotBooks() {
		Book highstPriceBook = selectHighstPrice();
		Book LowerPriceBook = selectLowerPrice();
		System.out.println("가장 비싼 책 : " + highstPriceBook.getBookName() + ", 가격 : " + highstPriceBook.getBookPrice());
		System.out.println("가장  싼 책 : " + LowerPriceBook.getBookName() + ", 가격 : " + LowerPriceBook.getBookPrice());
		System.out.printf("최고,최저 가격을 뺀 나머지 책들의 평균 가격 : %.2f\n" , selectAvg());
		System.out.println();
		
	}
	// 가장 비싼 책 탐색
	public Book selectHighstPrice() {
		Book highstPriceBook = bookList.get(0);
		for(int i=1; i<bookList.size(); i++) {
			if(highstPriceBook.getBookPrice()<bookList.get(i).getBookPrice()) {
				highstPriceBook = bookList.get(i);
			}
		}
		return highstPriceBook;
	}
	// 가장 싼 책 탐색
	public Book selectLowerPrice() {
		Book lowerPriceBook  = bookList.get(0);
		for(int i=1; i<bookList.size(); i++) {
			if(lowerPriceBook.getBookPrice()>bookList.get(i).getBookPrice()) {
				lowerPriceBook = bookList.get(i);
			}
		}
		return lowerPriceBook;
	}
	// 평균
	public double selectAvg() {
		return ((double)selectTotalPrice() - selectHighstPrice().getBookPrice() - selectLowerPrice().getBookPrice())/(bookList.size()-2);		
	}
	
	// 가격 총합
	public int selectTotalPrice() {
		int totalPrice=0;
		for(int i=0; i<bookList.size(); i++)
			totalPrice += bookList.get(i).getBookPrice();
		return totalPrice;
	}

	@Override
	public void updateBook(Book book) {
		int index;
		if((index = bookList.indexOf(book))!=-1) {
			bookList.set(index, book);
			System.out.println(book.getBookName() + "의 정보가 수정되었습니다.");
		} else {
			System.out.println(book.getBookName() + "의 정보를 찾을 수 없습니다.");
		}
		System.out.println();
	}

	@Override
	public void deleteBook(Book book) {
		if(bookList.remove(book)) {
			System.out.println(book.getBookName()+ "이/가 삭제 되었습니다.");
		} else {
			System.out.println("등록되지 않은 도서입니다.");
		}
		System.out.println();
	}

}
