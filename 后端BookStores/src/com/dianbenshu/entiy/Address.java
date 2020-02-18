package com.dianbenshu.entiy;

public class Address {
	int AddressId;
	String AddressName;
	int AddressUserId;
	String AddressPhone;
	String AddressDes;

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public String getAddressName() {
		return AddressName;
	}

	public void setAddressName(String addressName) {
		AddressName = addressName;
	}

	public int getAddressUserId() {
		return AddressUserId;
	}

	public void setAddressUserId(int addressUserId) {
		AddressUserId = addressUserId;
	}

	public String getAddressPhone() {
		return AddressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		AddressPhone = addressPhone;
	}

	public String getAddressDes() {
		return AddressDes;
	}

	public void setAddressDes(String addressDes) {
		AddressDes = addressDes;
	}

	public Address(int addressId, String addressName, int addressUserId, String addressPhone, String addressDes) {
		super();
		AddressId = addressId;
		AddressName = addressName;
		AddressUserId = addressUserId;
		AddressPhone = addressPhone;
		AddressDes = addressDes;
	}

	public Address(int addressId, String addressName, String addressPhone, String addressDes) {
		super();
		AddressId = addressId;
		AddressName = addressName;
		AddressPhone = addressPhone;
		AddressDes = addressDes;
	}

	public Address() {
	}
}
