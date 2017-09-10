package com.codetest.usermgmnt.service;

import com.codetest.usermgmnt.model.UserRegistration;

public interface UserManagementService {
	
	public String register(UserRegistration user);
	
	public UserRegistration getUserRegistrationInfo(String userId);
	
	public boolean isUserExisted(String userId);	

}
