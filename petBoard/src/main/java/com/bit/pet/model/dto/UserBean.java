package com.bit.pet.model.dto;

public class UserBean {
	private String userId;
	private String userPw;
	private String userEmail;
	private String userPhoneNum;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail + ", userPhoneNum="
				+ userPhoneNum + "]";
	}
	
	
}