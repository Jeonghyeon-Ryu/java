package com.yedam.java.home;

public interface BookProgram {
	public void printMenu();
	public int inputMenuNum();
	public void inputBook(BookAccess bookAccess);
	public int inputIsbn();
	public Book inputBookInfo();
	public void printAllBook(BookAccess bookAccess);
	public void printBook(BookAccess bookAccess);
	public void printRepot(BookAccess bookAccess);
	public void exit();
}
