package com.codetest.usermgmnt.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.codetest.usermgmnt.message.NotificationSender;
import com.codetest.usermgmnt.model.NotificationMessage;

@Component
public class NotificationSenderImpl implements NotificationSender {


	@Autowired
	private JmsTemplate messaging;

	@Override
	public void publishMessage(NotificationMessage message) {
		messaging.convertAndSend("queue.notify", message.getMessageData());
	}

}
