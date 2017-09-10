package com.codetest.usermgmnt.model;

import java.util.HashMap;
import java.util.Map;

public class NotificationMessage {

	private Map<String, String> data = new HashMap<String, String>();

	public NotificationMessage() {

	}

	public void addData(String name, String value) {
		data.put(name, value);
	}

	public Map<String, String> getMessageData() {
		return data;
	}
}
