package com.codetest.usermgmnt.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.codetest.usermgmnt.model.NotificationMessage;
import com.codetest.usermgmnt.model.SecretCode;
import com.codetest.usermgmnt.model.UserRegistration;

@Component
public class MessageUtil {
	
	@Value("${app.link}")
	private String appLink; 
	
	public NotificationMessage buildMessage(UserRegistration user){
		NotificationMessage message = new NotificationMessage();
		
		message.addData("email", user.getEmail());
		
		SecretCode code = new SecretCode();
		code.setUserId(user.getId());		
		code.setTimestamp(System.currentTimeMillis());
		
		String ecodedCode = SecretCodeUtil.encode(code.toString());
		
		message.addData("content", String.format("%s/auth/user/%s",appLink,ecodedCode));	
		
		return message;
	}

}
