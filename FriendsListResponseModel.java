package com.cap.model;

import java.util.ArrayList;
import java.util.List;

public class FriendsListResponseModel {

	@Override
	public String toString() {
		return "FriendsListResponseModel [count=" + count + ", frndList=" + frndList + ", success=" + success + "]";
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

	private int count;
	private List<String> frndList;
	private boolean success;
	
}
