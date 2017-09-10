package com.codetest.usermgmnt.model;

import java.util.HashMap;
import java.util.Map;

public class SecretCode {

	private String userId;

	private long timestamp = 0;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return String.format("userid=%s&timestamp=%d", userId, timestamp);
	}

	public static SecretCode generate(String codeStr) {
		SecretCode code = null;
		Map<String, String> map = new HashMap<String, String>();
		if (!codeStr.isEmpty()) {
			String[] tokens = codeStr.split("&");
			for (String token : tokens) {
				String[] keyvalues = token.split("=");
				if (keyvalues.length > 0) {
					map.put(keyvalues[0], keyvalues[1]);
				}
			}
			code = new SecretCode();
			if (map.containsKey("userid")) {
				code.setUserId(map.get("userid"));
			}
			if (map.containsKey("timestamp")) {
				code.setTimestamp(Long.parseLong(map.get("timestamp")));
			}
		}
		return code;
	}

	public boolean isValid(long expireTime) {
		long currentTimeStamp = System.currentTimeMillis();		
		if (!userId.isEmpty() && (currentTimeStamp - timestamp) <= expireTime) {
			return true;
		}
		return false;

	}

}
