package com.dianbenshu.entiy;

public class Order_Book {
	int Id;
	String Order_number;
	int BookId;
	int BookNum;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getOrder_number() {
		return Order_number;
	}
	public void setOrder_number(String order_number) {
		Order_number = order_number;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public int getBookNum() {
		return BookNum;
	}
	public void setBookNum(int bookNum) {
		BookNum = bookNum;
	}
	
	public Order_Book(int id, String order_number, int bookId, int bookNum) {
		super();
		Id = id;
		Order_number = order_number;
		BookId = bookId;
		BookNum = bookNum;
	}
	
	public Order_Book() {
		super();
	}
	
	public Order_Book( String order_number, int bookId, int bookNum) {
		super();
		Order_number = order_number;
		BookId = bookId;
		BookNum = bookNum;
	}
	
}
