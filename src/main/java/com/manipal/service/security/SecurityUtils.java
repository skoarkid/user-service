package com.manipal.service.security;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityUtils {
	
	public static String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public static boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
		{
			return true;
		}
		return false;
	}
}
