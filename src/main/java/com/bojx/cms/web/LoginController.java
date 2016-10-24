package com.bojx.cms.web;

import com.bojx.cms.service.LoginService;
import com.bojx.cms.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.render.JsonRender;

/**
 * 
 * @author syh
 * login controller
 *
 */
public class LoginController extends BaseController {
	public static LoginService loginService=new LoginService();
	
	public void index(){
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
	@Before(LoginValidator.class)
	public void login(){
		String username=getPara("username");
		String password=getPara("password");
		Record record=loginService.login(username, password, getRequest(), getResponse());
		render(new JsonRender(record).forIE());
	}
}
