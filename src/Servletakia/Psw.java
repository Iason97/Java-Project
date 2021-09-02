package Servletakia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Psw {
	static byte[] salt = new byte[] {-63, -25, -17, -32, 82, -48, -9, -67, -124, -89, -68, 75, 110, 42, 23, 42};
	static byte[] bytes;
	public static String getSecurePassword(String passwordToHash, byte[] salt2)
	{
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt2);
			 bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	public String Return_psw(String pass) {
		return getSecurePassword(pass,salt);
	}
}
