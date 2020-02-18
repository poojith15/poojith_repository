package com.cg.BankTransaction.entity;

public class Address {
	private String addressId;
	private String addressLine1;
	private String addressLine2;
	private String addressCity;
	private String addressState;
	private String addressCountry;
	private String addressZipcode;
	private Branch branch=new Branch();
	
	
	public Address() {
		
	}
	public Address(String addressId, String addressLine1, String addressLine2, String addressCity, String addressState,
			String addressCountry, String addressZipcode, Branch branch) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.addressZipcode = addressZipcode;
		this.branch = branch;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressid(String addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public String getAddressZipcode() {
		return addressZipcode;
	}
	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	public Branch getBrnch() {
		return branch;
	}
	public void setBrnch(Branch branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Address Id:"+addressId+"Address Line 1:"+addressLine1+"Address Line 2:"+addressLine2
				+"Address City:"+addressCity+"Address State:"+addressState+"Address Country:"+addressCountry
				+"Address Zipcode:"+addressZipcode+branch;
	}
	
	
}
