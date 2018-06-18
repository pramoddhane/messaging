package com.cap.message;

import java.util.ArrayList;
import java.util.List;

import com.cap.model.FriendsListRequestModel;
import com.cap.model.FriendsListResponseModel;

public class MockRepository {
	List<String> alliens;
	List<FriendsDb> frnds;
	
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
		/*
		 * List<FriendsDb> allFrnds = new ArrayList<FriendsDb>();
		 * frnds.forEach((k) -> { allFrnds.add(k); });
		 */
		return frnds;
	}

	public FriendsListResponseModel getAllFriendList(FriendsListRequestModel f1) {
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

	/*public FriendsDb getAllCommonFriendList(FriendsDb f1) {
		System.out.println("All FriendsDb===" + f1.getEmail() + "===" + frnds.size());

		FriendsDb allFrnds = new FriendsDb();
		for (String k : f1.getFriend()) {
			}
		

		return allFrnds;
	}*/
	}
