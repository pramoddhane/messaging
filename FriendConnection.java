package com.cap.service;

import org.springframework.http.ResponseEntity;

import com.cap.model.FriendConnectionRequestModel;

public interface FriendConnection {
	public ResponseEntity<Object> createFriendConnection( FriendConnectionRequestModel model);
}
