package com.dianbenshu.entiy;

public class ShoppingCar {
	int ShoppingCarId;
	int UserId;
	int BooksId;
	int Num;
	int Status;
	String CreateTime;
	String UpdateTime;
	String CartMessages;
	
	public int getShoppingCarId() {
		return ShoppingCarId;
	}
	public void setShoppingCarId(int shoppingCarId) {
		ShoppingCarId = shoppingCarId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getBooksId() {
		return BooksId;
	}
	public void setBooksId(int booksId) {
		BooksId = booksId;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
	public String getCartMessages() {
		return CartMessages;
	}
	public void setCartMessages(String cartMessages) {
		CartMessages = cartMessages;
	}
	
	public ShoppingCar(int shoppingCarId, int userId, int booksId, int num, int status, String createTime,
			String updateTime,String cartMessages) {
		super();
		ShoppingCarId = shoppingCarId;
		UserId = userId;
		BooksId = booksId;
		Num = num;
		Status = status;
		CreateTime = createTime;
		UpdateTime = updateTime;
		CartMessages = cartMessages;
	}
	
	public ShoppingCar() {
	}
	
	public ShoppingCar(int shoppingCarId,int booksId, int num) {
		super();
		ShoppingCarId = shoppingCarId;
		BooksId = booksId;
		Num = num;
	}
	
	public ShoppingCar(int userId, int booksId, int num, int status, String createTime,
			String cartMessages) {
		super();
		UserId = userId;
		BooksId = booksId;
		Num = num;
		Status = status;
		CreateTime = createTime;
		CartMessages = cartMessages;
	}
}
