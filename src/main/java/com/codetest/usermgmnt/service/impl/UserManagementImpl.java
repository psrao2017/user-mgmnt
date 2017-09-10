package com.codetest.usermgmnt.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.codetest.usermgmnt.common.AuthException;
import com.codetest.usermgmnt.common.UserUtil;
import com.codetest.usermgmnt.dao.UserManagementRepository;
import com.codetest.usermgmnt.entity.User;
import com.codetest.usermgmnt.model.UserRegistration;
import com.codetest.usermgmnt.service.UserManagementService;

@Service
@Transactional
public class UserManagementImpl implements UserManagementService {

	@Autowired
	private UserManagementRepository repository;

	@Override
	public String register(UserRegistration ur) {
		try {
			User user = UserUtil.toEntity(ur);
			if (user != null) {
				return repository.save(user).getUserId();
			} else {
				throw new AuthException("AUTH_8000",
						"Insufficient information for registration");
			}
		} catch (DataAccessException dae) {
			throw new AuthException("AUTH_7000", "User registration is failed");
		}
	}

	@Override
	public UserRegistration getUserRegistrationInfo(String userId) {
		try {
			User user = repository.findOne(userId);
			if (user == null) {
				throw new AuthException("AUTH_6000", "user doesn't exists");
			}
			UserRegistration ur = new UserRegistration();
			ur.setEmail(user.getEmail());
			ur.setName(user.getName());
			ur.setPincode(user.getPincode());
			ur.setId(user.getUserId());
			return ur;
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw new AuthException("AUTH_7000", "User fetching is failed");
		}
	}

	@Override
	public boolean isUserExisted(String userId) {
		boolean isExisted = false;

		if (!userId.isEmpty()) {
			User user = repository.findOne(userId);
			if (user != null) {
				isExisted = true;
			}
		}

		return isExisted;

	}

}
