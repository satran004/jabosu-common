package org.jabosu.common.util;

import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordEncoder {

	public static String encode(String password, String salt) {
		return md5(password + salt);
		
	}
	
	private static String md5(String input) {
		return DigestUtils.md5Hex( input );
	}
	
	public static String getSalt() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = new byte[20];
		secureRandom.nextBytes(salt);
		
		return Base64.encodeBase64String(salt);
	}

}
