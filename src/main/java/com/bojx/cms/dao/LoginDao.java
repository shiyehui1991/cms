package com.bojx.cms.dao;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class LoginDao {
	public Record queryUserInfo(String username){
		return Db.findFirst("select * from cms_user where name=?",username);
	}
	
	public String queryPassword(String username){
		return Db.queryStr("select password from cms_user where name=?",username);
	}
}
