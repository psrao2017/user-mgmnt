package com.codetest.usermgmnt.common;

import org.springframework.util.Base64Utils;

public class SecretCodeUtil {

	public static String encode(String code) {
		return Base64Utils.encodeToString(code.getBytes());
	}

	public static String decode(String code) {
		byte[] bytes = Base64Utils.decodeFromString(code);
		String srcCode = new String(bytes);
		return srcCode;
	}

}
