package com.cap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.model.BlockUpdatesRequestModel;
import com.cap.model.BlockUpdatesResponseModel;
import com.cap.model.CommonFriendsListRequestModel;
import com.cap.model.CommonFriendsListResponseModel;
import com.cap.model.FriendConnectionRequestModel;
import com.cap.model.FriendConnectionResponseModel;
import com.cap.model.FriendsListRequestModel;
import com.cap.model.FriendsListResponseModel;
import com.cap.model.SubscribeUpdatesRequestModel;
import com.cap.model.SubscribeUpdatesResponseModel;
import com.cap.model.UpdateResponseModel;
import com.cap.model.UpdatesRequestModel;
import com.cap.serviceImpl.FriendConnectionImpl;
import com.cap.serviceImpl.FriendsListImpl;

@Controller
public class MessageController {
	@Autowired MockRepository repo;

	@Autowired public FriendConnectionImpl friendConnectionService;
	@Autowired public FriendsListImpl friendsListImpl;
	
	private static final String CREATEFRIENDCONNECTION = "/createFriendConnection";
	private static final String GETFRIENDLIST = "/getFriendsList";
	private static final String GETCOMMONFRIENDSLIST = "/getCommonFriendsList";
	private static final String GETUPDATES = "/getUpdates";
	private static final String SUBSCRIBETOUPDATES = "/subscribeToUpdates";
	private static final String BLOCKUPDATES = "/blockUpdates";

	// API to create a friend connection between two email addresses.
	@RequestMapping(value = CREATEFRIENDCONNECTION, method = RequestMethod.POST)
	public ResponseEntity<Object> friendConnection(@RequestBody FriendConnectionRequestModel model) { 
		return friendConnectionService.createFriendConnection(model);
	}

	// API to retrieve the friends list for an email address
	@RequestMapping(value = GETFRIENDLIST, method = RequestMethod.POST)
	public ResponseEntity<Object> friendsList(@RequestBody FriendsListRequestModel model) { // throws
		return friendsListImpl.getFriendsList(model);
	}
	
	// API to retrieve the common friends list between two
	// email addresses
	@RequestMapping(value = GETCOMMONFRIENDSLIST, method = RequestMethod.POST)
	public @ResponseBody CommonFriendsListResponseModel getCommonFriendsList(
			@RequestBody CommonFriendsListRequestModel modle) {
		return new CommonFriendsListResponseModel();
	}

	// API to subscribe to updates from an email address
	@RequestMapping(value = SUBSCRIBETOUPDATES, method = RequestMethod.POST)
	public @ResponseBody SubscribeUpdatesResponseModel subscribeUpdates(
			@RequestBody SubscribeUpdatesRequestModel model) {
		return new SubscribeUpdatesResponseModel();
	}

	// API to block updates from an email address
	@RequestMapping(value = BLOCKUPDATES, method = RequestMethod.POST)
	public @ResponseBody BlockUpdatesResponseModel blockUpdates(@RequestBody BlockUpdatesRequestModel model) {
		return new BlockUpdatesResponseModel();
	}

	// API to retrieve all email addresses that can receive
	// updates from an email address
	@RequestMapping(value = GETUPDATES, method = RequestMethod.POST)
	public @ResponseBody UpdateResponseModel getUpdates(@RequestBody UpdatesRequestModel model) {
		return new UpdateResponseModel();
	}

}
