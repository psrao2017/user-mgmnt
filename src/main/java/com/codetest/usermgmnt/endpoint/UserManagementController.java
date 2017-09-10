package com.codetest.usermgmnt.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.usermgmnt.common.AuthException;
import com.codetest.usermgmnt.common.BaseResponse;
import com.codetest.usermgmnt.common.ErrorCode;
import com.codetest.usermgmnt.common.MessageUtil;
import com.codetest.usermgmnt.common.SecretCodeUtil;
import com.codetest.usermgmnt.model.SecretCode;
import com.codetest.usermgmnt.model.UserRegistration;
import com.codetest.usermgmnt.service.NotificationService;
import com.codetest.usermgmnt.service.UserManagementService;

@RestController
@RequestMapping("/auth")
public class UserManagementController {

	@Value("${expire.time}")
	private long expireTime;

	@Autowired
	private UserManagementService service;

	@Autowired
	private MessageUtil msgUtil;

	@Autowired
	private NotificationService notification;

	@PostMapping(path = "/register", consumes = "application/json")
	public String register(@Valid @RequestBody UserRegistration userRegis) {

		String userId = service.register(userRegis);
		return userId;
	}

	@GetMapping(path = "/login/{d}", produces = "application/json")
	public ResponseEntity<BaseResponse> login(@PathVariable("d") String userId) {

		UserRegistration user = service.getUserRegistrationInfo(userId);

		if (user != null) {
			notification.postMailMessage(msgUtil.buildMessage(user));
			BaseResponse succResp = new BaseResponse();
			succResp.setMessage("Login request recieved. please check mail for user details link");
			return ResponseEntity.ok(succResp);
		} else {
			throw new AuthException(ErrorCode.AUTH_NO_USER,
					"User doesn't exists");
		}

	}

	@GetMapping(path = "/user/{sCode}", produces = "application/json")
	@ResponseBody
	public UserRegistration showDetails(@PathVariable("sCode") String key) {

		SecretCode code = SecretCode.generate(SecretCodeUtil.decode(key));

		if (!code.isValid(expireTime)) {
			throw new AuthException(ErrorCode.AUTH_INVALID_LINK, "Invalid link");
		}
		UserRegistration user = service.getUserRegistrationInfo(code
				.getUserId());
		if (user == null) {
			throw new AuthException(ErrorCode.AUTH_NO_USER,
					"User doesn't exists");
		}
		return user;
	}

}
