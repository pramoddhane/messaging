package com.cap.serviceImpl;

import java.awt.Dialog.ModalExclusionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cap.controller.EmailValidator;
import com.cap.controller.MockRepository;
import com.cap.model.FriendsListRequestModel;
import com.cap.model.FriendsListResponseModel;
import com.cap.service.FriendsList;

@Service
public class FriendsListImpl implements FriendsList {
//@Autowired MockRepository repo;
	MockRepository repo = new MockRepository();
	public ResponseEntity<Object> getFriendsList(FriendsListRequestModel model) {
		FriendsListResponseModel ob = null;
		if(EmailValidator.isValid(model.getEmail())) {
			System.out.println(model.getEmail());
			try {
			ob = repo.getAllFriendList(model); // NoDataFoundException{
			System.out.println(ob);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			return new ResponseEntity<Object>("Inavlid Email ID", HttpStatus.BAD_REQUEST);
		}
		if (!(ob.getFrndList() == null)) {
			return new ResponseEntity<Object>(ob, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("No Friend List available", HttpStatus.NOT_FOUND);
		}
	}

}
