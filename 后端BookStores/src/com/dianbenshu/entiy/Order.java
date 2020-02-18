package com.dianbenshu.entiy;

public class Order {
	int OrderId;
	String Order_number;
	int UserId;
	int Pay_price;
	int Is_pay;
	String Pay_time;
	int Is_ship;
	String Ship_time;
	int Is_receipt;
	String Receipt_time;
	String Ship_number;
	int Status;
	String Create_time;
	String Update_time;
	
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public String getOrder_number() {
		return Order_number;
	}
	public void setOrder_number(String order_number) {
		Order_number = order_number;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getPay_price() {
		return Pay_price;
	}
	public void setPay_price(int pay_price) {
		Pay_price = pay_price;
	}
	public int getIs_pay() {
		return Is_pay;
	}
	public void setIs_pay(int is_pay) {
		Is_pay = is_pay;
	}
	public String getPay_time() {
		return Pay_time;
	}
	public void setPay_time(String pay_time) {
		Pay_time = pay_time;
	}
	public int getIs_ship() {
		return Is_ship;
	}
	public void setIs_ship(int is_ship) {
		Is_ship = is_ship;
	}
	public String getShip_time() {
		return Ship_time;
	}
	public void setShip_time(String ship_time) {
		Ship_time = ship_time;
	}
	public int getIs_receipt() {
		return Is_receipt;
	}
	public void setIs_receipt(int is_receipt) {
		Is_receipt = is_receipt;
	}
	public String getReceipt_time() {
		return Receipt_time;
	}
	public void setReceipt_time(String receipt_time) {
		Receipt_time = receipt_time;
	}
	public String getShip_number() {
		return Ship_number;
	}
	public void setShip_number(String ship_number) {
		Ship_number = ship_number;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getCreate_time() {
		return Create_time;
	}
	public void setCreate_time(String create_time) {
		Create_time = create_time;
	}
	public String getUpdate_time() {
		return Update_time;
	}
	public void setUpdate_time(String update_time) {
		Update_time = update_time;
	}
	
	public Order(int orderId, String order_number, int userId, int pay_price, int is_pay, String pay_time, int is_ship,
			String ship_time, int is_receipt, String receipt_time, String ship_number, int status, String create_time,
			String update_time) {
		super();
		OrderId = orderId;
		Order_number = order_number;
		UserId = userId;
		Pay_price = pay_price;
		Is_pay = is_pay;
		Pay_time = pay_time;
		Is_ship = is_ship;
		Ship_time = ship_time;
		Is_receipt = is_receipt;
		Receipt_time = receipt_time;
		Ship_number = ship_number;
		Status = status;
		Create_time = create_time;
		Update_time = update_time;
	}
	
	public Order() {
		super();
	}
	
	public Order(String order_number, int userId, int pay_price, int is_pay, String pay_time, int is_ship,
			String ship_time, int is_receipt, String receipt_time, String ship_number, int status, String create_time,
			String update_time) {
		super();
		Order_number = order_number;
		UserId = userId;
		Pay_price = pay_price;
		Is_pay = is_pay;
		Pay_time = pay_time;
		Is_ship = is_ship;
		Ship_time = ship_time;
		Is_receipt = is_receipt;
		Receipt_time = receipt_time;
		Ship_number = ship_number;
		Status = status;
		Create_time = create_time;
		Update_time = update_time;
	}
	
}
