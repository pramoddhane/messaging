package com.messaging.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cap.controller.MessageController;
import com.cap.controller.MockRepository;
import com.cap.model.FriendConnectionRequestModel;
import com.cap.model.FriendConnectionResponseModel;
import com.cap.model.FriendsListRequestModel;
import com.cap.model.FriendsListResponseModel;
import com.cap.serviceImpl.FriendConnectionImpl;
import com.cap.serviceImpl.FriendsListImpl;

import junit.framework.TestCase;

public class ControllerTest extends TestCase {
	
	//MockRepository mockRepository = new MockRepository();
	//@Autowired MockRepository repo;
	public void testFriendConnection() {
		//fail("Not yet implemented");
		MessageController controller = new MessageController();
		controller.friendConnectionService = new FriendConnectionImpl();
		controller.friendsListImpl = new FriendsListImpl();
		
		FriendConnectionRequestModel model = new FriendConnectionRequestModel();
		List<String> list = new ArrayList<String>();
		list.add("abc@gmail.com");
		list.add("xyz@gmail.com");
		model.setFriends(list);
		controller.friendConnection(model);
		
		ResponseEntity <Object> ob = controller.friendConnection(model);
		//FriendConnectionResponseModel object = controller.friendConnection(model);
		assertNotNull(ob);
		assertEquals(HttpStatus.OK, ob.getStatusCode());
	}

	
	public void testGetFriendsList() {
		//fail("Not yet implemented");
		//MockRepository mockRepository = new MockRepository();
		MessageController controller = new MessageController();
		controller.friendConnectionService = new FriendConnectionImpl();
		controller.friendsListImpl = new FriendsListImpl();
		
		FriendsListRequestModel model = new FriendsListRequestModel();
		model.setEmail("andy@example.com");
		//controller.friendsList(model);
		
		ResponseEntity<Object> ob = controller.friendsList(model);
		assertNotNull(ob);
		assertEquals(HttpStatus.OK, ob.getStatusCode());
	}

}
