package com.bluebricks.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;

public class EmployeeInfo implements Serializable {
	private String name;
	private String phone;
	private String email;
	private String address;
	private byte[] image ;

	public EmployeeInfo() {
	}

	
	public EmployeeInfo(String name, String phone, String email, String address, byte[] image) {
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.address = address;
	this.image = image ;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
