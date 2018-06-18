package com.cap.model;

import java.util.ArrayList;
import java.util.List;

public class CommonFriendsListResponseModel {

	private static List<String> Friends = new ArrayList<String>();
	private String success = "true";
	private int count = Friends.size();
	
	static{
	Friends.add("common@example.com");
	Friends.add("common2@example.com");
	//success = "true";
	//count = Friends.size();
	}
	public  String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getFriends() {
		return Friends;
	}

	public void setFriends(List<String> friends) {
		Friends = friends;
	}

}
