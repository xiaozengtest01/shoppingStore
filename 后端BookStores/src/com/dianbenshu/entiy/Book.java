package com.dianbenshu.entiy;

import java.util.Date;
import java.util.List;


public class Book {
	int BookId;
	String BookName;
	int BookNum;
	String BookCover;
	int BookClass;
	double BookPrice;
	String BookDes;
	String BookAuthor;
	String BookPublish;
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public int getBookNum() {
		return BookNum;
	}
	public void setBookNum(int bookNum) {
		BookNum = bookNum;
	}
	public String getBookCover() {
		return BookCover;
	}
	public void setBookCover(String bookCover) {
		BookCover = bookCover;
	}
	public int getBookClass() {
		return BookClass;
	}
	public void setBookClass(int bookClass) {
		BookClass = bookClass;
	}
	public double getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(double bookPrice) {
		BookPrice = bookPrice;
	}
	public String getBookDes() {
		return BookDes;
	}
	public void setBookDes(String bookDes) {
		BookDes = bookDes;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public String getBookPublish() {
		return BookPublish;
	}
	public void setBookPublish(String bookPublish) {
		BookPublish = bookPublish;
	}
	public Book(int bookId, String bookName, int bookNum, String bookCover, int bookClass, double bookPrice,
			String bookDes, String bookAuthor, String bookPublish) {
		super();
		BookId = bookId;
		BookName = bookName;
		BookNum = bookNum;
		BookCover = bookCover;
		BookClass = bookClass;
		BookPrice = bookPrice;
		BookDes = bookDes;
		BookAuthor = bookAuthor;
		BookPublish = bookPublish;
	}
	public Book(int bookId, String bookName,  String bookCover, double bookPrice,String bookAuthor) {
		super();
		BookId = bookId;
		BookName = bookName;
		BookCover = bookCover;
		BookPrice = bookPrice;
		BookAuthor = bookAuthor;
	}
	public Book() {
		super();
	
	}

	
	
}
