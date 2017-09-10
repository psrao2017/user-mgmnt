package com.codetest.usermgmnt.common;

import com.codetest.usermgmnt.entity.User;
import com.codetest.usermgmnt.model.UserRegistration;

public class UserUtil {

	public static User toEntity(UserRegistration ur) {
		User user = null;
		if (ur != null) {

			user = new User();
			user.setEmail(ur.getEmail());
			user.setName(ur.getName());
			user.setPincode(ur.getPincode());
			user.setUserId(ur.getId());
		}
		return user;
	}

	public static UserRegistration toModel(User user) {
		UserRegistration ur = null;

		if (user != null) {
			ur = new UserRegistration();
			ur.setEmail(user.getEmail());
			ur.setName(user.getName());
			ur.setPincode(user.getPincode());
			ur.setId(user.getUserId());
		}
		return ur;
	}

}
