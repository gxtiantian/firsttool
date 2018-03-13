package com.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AesDataTools {
	private static final String password = "fengxiang==@#$%^&*(1)4717331";
	private static final int length = 128;

	private byte[] encrypt(String content, String password) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(password.getBytes());
		kgen.init(length, secureRandom);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		byte[] byteContent = content.getBytes("utf-8");
		cipher.init(1, key);
		byte[] result = cipher.doFinal(byteContent);
		return result;
	}

	private byte[] decrypt(byte[] content, String password) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(password.getBytes());
		kgen.init(length, secureRandom);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(2, key);
		byte[] result = cipher.doFinal(content);
		return result;
	}

	private byte[] encrypt2(String content, String password) {
		try {
			SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(1, key);
			return cipher.doFinal(byteContent);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String encode(String content) throws Exception {
		byte[] encryptResult = encrypt(content, password);
		return Base64.getEncoder().encodeToString(encryptResult);
	}

	public String decode(String content) throws Exception {
		byte[] decryptResult = decrypt(Base64.getDecoder().decode(content), password);
		return new String(decryptResult, "UTF-8");
	}
	
	
	public static void main(String[] args) throws Exception {
		AesDataTools aesDataTools = new AesDataTools();
		String encode = aesDataTools.encode("123456");
		System.out.println(encode);
		String decode = aesDataTools.decode(encode);
		System.out.println(decode);
	}
}