package com.cap.service;

import org.springframework.http.ResponseEntity;

import com.cap.model.FriendsListRequestModel;

public interface FriendsList {
	public ResponseEntity<Object>getFriendsList(FriendsListRequestModel model);
}
