package com.bojx.cms.util;

import com.jfinal.kit.HashKit;
/**
 * 
 * @author syh
 * encrypt util
 */
public class EncryptUtil {
	public static final String SALT="bojx";
	
	public static String md5(String password){
		return HashKit.md5(password+SALT);
	}
	
	public static void main(String[] args) {
		System.out.println(md5("123456"));
	}
}
