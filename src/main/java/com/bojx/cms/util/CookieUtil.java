package com.bojx.cms.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	
	public static void addCookie(HttpServletResponse response,String cookieName,String cookieValue,int expiry){
		Cookie cookie=new Cookie(cookieName,cookieValue);
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}
	
	public static void removeCookie(HttpServletResponse response,String cookieName){
		Cookie cookie = new Cookie(cookieName, "");  
	    cookie.setMaxAge(0);   
	    response.addCookie(cookie);
	}
}
