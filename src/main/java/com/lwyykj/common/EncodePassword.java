package com.lwyykj.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class EncodePassword {
	// 加密
	public static String encodePassword(String password) {
		// 加盐
		String Salt = "qwer" + password + "zxcv";
		// password = "qwerty" + password + "xyzc";
		// 1.MD5 算法
		String algorithm = "MD5";
		char[] encodeHex = null;
		try {
			// MD5加密
			MessageDigest instance = MessageDigest.getInstance(algorithm);
			// 加密后的密文
			byte[] digest = instance.digest(Salt.getBytes());
			//
			// 2.十六进制
			encodeHex = Hex.encodeHex(digest);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(encodeHex);
	}
	// 测试
//	 public static void main(String[] args) {
//	 EncodePassword encodePassword = new EncodePassword();
//	 String w = encodePassword.encodePassword("11");
//	 System.out.println(w);
//	 }
}
