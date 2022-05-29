package com.yedam.java.home;

public class Book {
	private static int SerialISBN = 1000;
	private int isbn;
	private String bookName;
	private int bookPrice;
	
	public Book() { }
	public Book(String bookName, int bookPrice) {
		this.isbn = ++Book.SerialISBN;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
}
