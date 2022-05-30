package com.yedam.java.home;

import java.util.Scanner;

public class BookSystem implements BookProgram {
	// 필드
	Scanner sc = new Scanner(System.in);
	
	// 생성자
	public BookSystem() {}
	
	// 메소드
	public void printMenu() {
		System.out.println("==============================================");
		System.out.println("1.도서등록 | 2.도서목록 | 3.도서검색 | 4.도서분석 | 5.종료");
		System.out.println("==============================================");
	}
	public int inputMenuNum() {
		System.out.print("메뉴선택 > ");
		return Integer.parseInt(sc.nextLine());
	}
	public int inputIsbn() {
		System.out.print("도서 ISBN 입력 > ");
		return Integer.parseInt(sc.nextLine());
	}
	public Book inputBookInfo() {
		System.out.print("도서이름 입력 > ");
		String bookName = sc.nextLine();
		System.out.print("도서가격 입력 > ");
		int bookPrice = Integer.parseInt(sc.nextLine());
		return new Book(bookName,bookPrice);
	}
	@Override
	public void inputBook(BookAccess bookAccess) {
		bookAccess.createBook(inputBookInfo());
	}

	@Override
	public void printAllBook(BookAccess bookAccess) {
		Book[] books = bookAccess.selectBooks();
		if(books.length!=0) {
			System.out.printf("ISBN\t\t도서이름\t\t가격\t\t\n");
			for(int i=0; i<books.length; i++) {
				System.out.printf("%d\t\t%s\t\t%d\t\t\n",books[i].getIsbn(), books[i].getBookName(), books[i].getBookPrice());
			}
		} else {
			System.out.println("등록된 도서가 없습니니다.");
		}
		System.out.println();
	}

	@Override
	public void printBook(BookAccess bookAccess) {
		Book book = bookAccess.selectBook(inputIsbn());
		if(book!=null) {
			System.out.printf("ISBN\t\t도서이름\t\t가격\t\t\n");
			System.out.printf("%d\t\t%s\t\t%d\t\t\n",book.getIsbn(), book.getBookName(), book.getBookPrice());
		} else {
			System.out.println("입력하신 번호에 해당하는 도서가 없습니다.");
		}
		System.out.println();
			
	}

	@Override
	public void printRepot(BookAccess bookAccess) {
		bookAccess.selectRepotBooks();
	}
	
	public void exit() {
		System.out.println("종료합니다.");
	}

}
