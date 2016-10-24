package com.bojx.cms.web;


import com.bojx.cms.service.LoginService;
import com.bojx.cms.util.CookieUtil;
import com.bojx.cms.util.EncryptUtil;
import com.bojx.cms.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.render.JsonRender;

/**
 * 
 * @author syh
 * login controller
 *
 */

public class LoginController extends BaseController {
	public static Log LOG=Log.getLog(LoginController.class);
	public static LoginService loginService=new LoginService();
	
	@Clear
	public void index(){
		render("index.html");
	}
	
	@Clear
	public void login(){
		render("login.html");
	}
	
	/*
	 * login interface:this is used to login in;
	 * (1) validate the format of username and password;
	 * (2) query username from the database,
	 * 	   if username is not exist ,return " username is not exist ";
	 *     if username is exist ,but the account is locked,return "username is locked";
	 *     else ,do next;
	 * (3) compare the password from front with the password from database;
	 *     if they are not equal,return "password is incorrect";
	 *     else,set cookie the username and the token,return "login success";
	 */
	@Clear
	@Before(LoginValidator.class)
	public void loginPost(){
		String username=getPara("username");
		String password=getPara("password");
		Record result=loginService.login(username, password);
		if("00".equals(result.get("code"))){
			String ssid=EncryptUtil.md5(username);
			CookieUtil.addCookie(getResponse(), "username", username, 3600);
			CookieUtil.addCookie(getResponse(), "ssid", ssid, 3600);
		}
		render(new JsonRender(result).forIE());
	}
	
	/**
	 * logout interface
	 */
	public void logout(){
		CookieUtil.removeCookie(getResponse(), "username");
		CookieUtil.removeCookie(getResponse(), "ssid");
		redirect("/");
	}
}
