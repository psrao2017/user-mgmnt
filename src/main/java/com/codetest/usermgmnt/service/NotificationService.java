package com.codetest.usermgmnt.service;

import com.codetest.usermgmnt.model.NotificationMessage;

public interface NotificationService {

	public void postMailMessage(NotificationMessage message);

}
