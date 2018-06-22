package com.cap.controller;

import java.util.List;

public class FriendsDb {

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<String> getFrndList() {
		return frndList;
	}
	public void setFrndList(List<String> frndList) {
		this.frndList = frndList;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	private String email;
	private int count;
	private List<String> frndList;
	private boolean success;
	
}
