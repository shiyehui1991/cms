package com.bojx.cms.service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bojx.cms.dao.LoginDao;
import com.bojx.cms.util.EncryptUtil;
import com.jfinal.plugin.activerecord.Record;

public class LoginService {
	
	public static LoginDao dao=new LoginDao();
	public Record login(String username,String password,HttpServletRequest request,HttpServletResponse response){
		Record result=new Record();
		Record userRecord=dao.queryUserInfo(username);
		if(userRecord==null){
			result.set("code", "01");
			result.set("msg", "用户名不存在");
			return result;
		}else if("Y".equals(userRecord.getStr("is_locked"))){
			result.set("code", "02");
			result.set("msg", "用户已锁定");
			return result;
		}else{
			String encryptPass=dao.queryPassword(username);
			if(!EncryptUtil.md5(password).equals(encryptPass)){
				result.set("code","03");
				result.set("msg", "密码不正确");
				return result;
			}else{//login success
				String ssid=EncryptUtil.md5(username);
				Cookie userNameCookie=new Cookie("username", username);
				userNameCookie.setMaxAge(3600);
				Cookie ssidCookie=new Cookie("ssid", ssid);
				ssidCookie.setMaxAge(3600);
				response.addCookie(userNameCookie);
				response.addCookie(ssidCookie);
				result.set("code","00");
				result.set("msg", "登录成功");
				return result;
			}
		}
		
	}
}
