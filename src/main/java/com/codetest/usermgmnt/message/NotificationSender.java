package com.codetest.usermgmnt.message;

import com.codetest.usermgmnt.model.NotificationMessage;

public interface NotificationSender {
	
	public void publishMessage(NotificationMessage message);

}
