package com.cap.model;

import java.util.ArrayList;
import java.util.List;

public class UpdateResponseModel {
	private static List<String> recipients = new ArrayList<String>();
	private String success = "true";
	
	static{
		recipients.add("lisa@example.com");
		recipients.add("kate@example.com");
	}
	
	public  String getSuccess() {
		return success;
	}

	public static List<String> getRecipients() {
		return recipients;
	}

	public static void setRecipients(List<String> recipients) {
		UpdateResponseModel.recipients = recipients;
	}

	public void setSuccess(String success) {
		this.success = success;
	}


}
