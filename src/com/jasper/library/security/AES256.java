/*
 * Filename: AES256.java
 * Subject: AES256 구현하기
 * 
 * Description:
 * https://commons.apache.org/proper/commons-codec/
 * 2019-11-09 / Jasper / PHP 7.3과 호환성 실험결과: 호환되지 않음.
 * 
 */

package com.jasper.library.security;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256 {
	 
	// public static byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }; 
	public static byte[] ivBytes = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; 
	// public static byte[] ivBytes = { 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4 }; 
	 
	public static String aes_encode(String str, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException { 
	 
		byte[] textBytes = str.getBytes(StandardCharsets.UTF_8); 
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes); 
		SecretKeySpec newKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"); 
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); 
		cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec); 
		 
		return org.apache.commons.codec.binary.Base64.encodeBase64String(cipher.doFinal(textBytes)); 
	} 
	 
	public static String aes_decode(String str, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException { 
	 
		byte[] textBytes = org.apache.commons.codec.binary.Base64.decodeBase64(str); 
		//byte[] textBytes = str.getBytes("UTF-8"); 
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes); 
		SecretKeySpec newKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"); 
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); 
		cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec); 
		return new String(cipher.doFinal(textBytes), StandardCharsets.UTF_8); 
	} 

	  
}
