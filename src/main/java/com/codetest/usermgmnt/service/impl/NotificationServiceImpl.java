package com.codetest.usermgmnt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetest.usermgmnt.message.NotificationSender;
import com.codetest.usermgmnt.model.NotificationMessage;
import com.codetest.usermgmnt.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationSender notification;

	@Override
	public void postMailMessage(NotificationMessage message) {
		if (message != null) {
			notification.publishMessage(message);
		}
	}

}
