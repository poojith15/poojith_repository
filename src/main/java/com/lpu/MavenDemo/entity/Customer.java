package com.lpu.MavenDemo.entity;

import java.time.LocalDate;

/**
 * 
 * @author poojith This is an entity class which contains customer deatils and
 *         address object.
 */
public class Customer {
	private String customerId;
	private String customerName;
	private Address customerAddress = new Address();
	private String customerAadhar;
	private String customaerPan;
	private String customaerContact;
	private String customaerGender;
	private LocalDate customaerDob;

	public Customer() {

	}

	public Customer(String customerId, String customerName, Address customerAddress, String customerAadhar,
			String customaerPan, String customaerContact, String customaerGender, LocalDate customaerDob) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerAadhar = customerAadhar;
		this.customaerPan = customaerPan;
		this.customaerContact = customaerContact;
		this.customaerGender = customaerGender;
		this.customaerDob = customaerDob;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerAadhar() {
		return customerAadhar;
	}

	public void setCustomerAadhar(String customerAadhar) {
		this.customerAadhar = customerAadhar;
	}

	public String getCustomaerPan() {
		return customaerPan;
	}

	public void setCustomaerPan(String customaerPan) {
		this.customaerPan = customaerPan;
	}

	public String getCustomaerContact() {
		return customaerContact;
	}

	public void setCustomaerContact(String customaerContact) {
		this.customaerContact = customaerContact;
	}

	public String getCustomaerGender() {
		return customaerGender;
	}

	public void setCustomaerGender(String customaerGender) {
		this.customaerGender = customaerGender;
	}

	public LocalDate getCustomaerDob() {
		return customaerDob;
	}

	public void setCustomaerDob(LocalDate customaerDob) {
		this.customaerDob = customaerDob;
	}

	@Override
	public String toString() {
		return "Customer Id:" + customerId + "Customer Name:" + customerName + customerAddress + "Customer Aadhar:"
				+ customerAadhar + "Customaer Pan:" + customaerPan + "Customaer Contact:" + customaerContact
				+ "Customaer Gender:" + customaerGender + "Customaer Date of birth:" + customaerDob;
	}

}
