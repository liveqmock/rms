package org.durcframework.rms.util;

import org.durcframework.exception.DurcException;

public class PasswordUtil {

	
	public static String createHash(String password){
		try {
			return PasswordHash.createHash(password);
		} catch (Exception e) {
			throw new DurcException("密码加密出错");
		} 
	}
	
	public static boolean validatePassword(String password, String correctHash){
		try {
			return PasswordHash.validatePassword(password, correctHash);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public static void main(String[] args) {
		System.out.println(createHash("21232f297a57a5a743894a0e4a801fc3"));
	}
	
}
