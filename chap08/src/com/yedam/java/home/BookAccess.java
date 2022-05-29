package com.yedam.java.home;

public interface BookAccess {
	public void createBook(Book book);
	public Book[] selectBooks();
	public Book selectBook(int isbn);
	public void selectRepotBooks();
	public void updateBook(Book book);
	public void deleteBook(Book book);
}
