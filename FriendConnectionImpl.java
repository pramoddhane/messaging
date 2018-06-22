package com.cap.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cap.controller.EmailValidator;
import com.cap.controller.FriendsDb;
import com.cap.controller.MockRepository;
import com.cap.model.FriendConnectionRequestModel;
import com.cap.model.FriendConnectionResponseModel;
import com.cap.service.FriendConnection;

@Service
public class FriendConnectionImpl implements FriendConnection {

	//@Autowired MockRepository repo;
	MockRepository repo = new MockRepository();
	
	public ResponseEntity<Object> createFriendConnection(FriendConnectionRequestModel model) {
		// TODO Auto-generated method stub
		System.out.println(model.getFriends());
		if (model.getFriends().size() == 2) // NoDataFoundException{
		{
			for (String s : model.getFriends()) {
				if (EmailValidator.isValid(s)) {
					System.out.println("test1");
					if (repo.isExist(s)) {
						System.out.println("test");
						FriendsDb existingList = new FriendsDb();
						existingList = repo.emailFriends(s);
						List<String> li = new ArrayList<String>(existingList.getFrndList());
						if ((s.equals(existingList.getEmail()))) {
							if (!(li.contains(s))) {
								if (s == model.getFriends().get(0)) {
									li.add(model.getFriends().get(1));
								} else {
									li.add(model.getFriends().get(0));
								}
							}
						}
						existingList.setFrndList(li);
						repo.frnds.add(existingList);

					} else {
						FriendsDb fr = new FriendsDb();
						fr.setEmail(s);
						ArrayList<String> frndsList = new ArrayList<String>();
						if (s == model.getFriends().get(0)) {
							frndsList.add(model.getFriends().get(1));
						} else {
							frndsList.add(model.getFriends().get(0));
						}

						// frndsList.add("lzmn@cap.com");
						fr.setFrndList(frndsList);
						repo.frnds.add(fr);

					}
				} else {
					return new ResponseEntity<Object>("Inavlid Email ID", HttpStatus.BAD_REQUEST);
				}
			}
			FriendConnectionResponseModel ob = new FriendConnectionResponseModel();
			ob.setSuccess(true);
			return new ResponseEntity<Object>(ob, HttpStatus.OK);
		} else
			return new ResponseEntity<Object>("Please insert two email Ids ", HttpStatus.BAD_REQUEST);
	}

}
