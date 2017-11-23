package com.spring.domain.custom;

import com.spring.domain.User;

public class UserCustom {
	private String userName;
	private String email;
	private String avatar;
	private String password;
	private String address;
	private String phoneNumber;

	public UserCustom() {

	}

	public UserCustom(String userName, String email, String avatar, String password, String address,
			String phoneNumber) {
		super();
		this.userName = userName;
		this.email = email;
		this.avatar = avatar;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User converToUserCustom() {
		return new User(userName, email, avatar, password, address, phoneNumber);
	}

}
