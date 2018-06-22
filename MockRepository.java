package com.cap.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.cap.model.FriendsListRequestModel;
import com.cap.model.FriendsListResponseModel;

@Component
public class MockRepository {
	List<String> alliens;
	public List<FriendsDb> frnds;

	public MockRepository() {
		frnds = new ArrayList<FriendsDb>();
		FriendsDb fr = new FriendsDb();
		fr.setEmail("andy@example.com");
		ArrayList<String> frndsList = new ArrayList<String>();
		frndsList.add("pqr@cap.com");
		frndsList.add("lmn@cap.com");
		fr.setFrndList(frndsList);
		frnds.add(fr);
		// ---adding friend 2

		FriendsDb fr2 = new FriendsDb();
		fr2.setEmail("pqr@cap.com");
		frndsList = new ArrayList<String>();
		frndsList.add("abc@cap.com");
		frndsList.add("lmn@cap.com");
		fr2.setFrndList(frndsList);

		frnds.add(fr2);

	}

	public List<FriendsDb> getAllFriend() {
		System.out.println("All FriendsDb");
		return frnds;
	}

	public boolean isExist(String email) {
		System.out.println("All FriendsDb===" + email + "===" + frnds.size());
		boolean result = false;
		for (FriendsDb k : frnds) {
			System.out.println("in loop==" + k.getEmail() + "====" + k.getEmail().equals(email));
			if (k.getEmail().equals(email)) {
				result = true;
			}
		}

		return result;
	}

	public FriendsDb emailFriends(String email) {
		FriendsDb existingList = new FriendsDb();

		for (FriendsDb k : frnds) {
			System.out.println("in loop emailFriends==" + k.getEmail() + "====" + k.getEmail().equals(email));
			if (k.getEmail().equals(email)) {
				existingList.setEmail(k.getEmail());
				existingList.setFrndList(k.getFrndList());
				existingList.setSuccess(true);
				frnds.remove(k);
			}
		}
		return existingList;
	}
	
	public FriendsListResponseModel getAllFriendObject(FriendsListRequestModel f1) {
		System.out.println("All FriendsDb===" + f1.getEmail() + "===" + frnds.size());
		FriendsListResponseModel allFrnds = new FriendsListResponseModel();
		for (FriendsDb k : frnds) {
			System.out.println("in loop==" + k.getEmail() + "====" + k.getEmail().equals(f1.getEmail()));
			if (k.getEmail().equals(f1.getEmail())) {
				System.out.println("in true");
				k.setSuccess(true);
				k.setCount(k.getFrndList().size());
				allFrnds.setCount(k.getFrndList().size());
				allFrnds.setFrndList(k.getFrndList());
				allFrnds.setSuccess(true);

			}
		}

		return allFrnds;
	}

	public FriendsListResponseModel getAllFriendList(FriendsListRequestModel f1) {
		MockRepository mockRepository = new MockRepository();
		System.out.println("All FriendsDb===" + f1.getEmail() + "===" + frnds.size());
		FriendsListResponseModel allFrnds = new FriendsListResponseModel();
		for (FriendsDb k : frnds) {
			System.out.println("in loop==" + k.getEmail() + "====" + k.getEmail().equals(f1.getEmail()));
			if (k.getEmail().equals(f1.getEmail())) {
				System.out.println("in true");
				k.setSuccess(true);
				k.setCount(k.getFrndList().size());
				allFrnds.setCount(k.getFrndList().size());
				allFrnds.setFrndList(k.getFrndList());
				allFrnds.setSuccess(true);

			}
		}

		return allFrnds;
	}

	private ArrayList<String> returnList(String mail) {
		ArrayList<String> l = new ArrayList<String>();
		return l;
	}

	/*
	 * public FriendsDb getAllCommonFriendList(FriendsDb f1) {
	 * System.out.println("All FriendsDb===" + f1.getEmail() + "===" +
	 * frnds.size());
	 * 
	 * FriendsDb allFrnds = new FriendsDb(); for (String k : f1.getFriend()) { }
	 * 
	 * 
	 * return allFrnds; }
	 */
}
