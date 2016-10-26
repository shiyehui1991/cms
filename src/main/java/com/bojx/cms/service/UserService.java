package com.bojx.cms.service;

import com.bojx.cms.model.Article;
import com.bojx.cms.model.Categroy;
import com.bojx.cms.model.Depart;
import com.bojx.cms.model.User;

public class UserService {
	public void save(Article article){
		long categroyId=article.getLong("categroy_id");
		Categroy categroy=Categroy.dao.findById(categroyId);
		String categroyName=categroy.getStr("name"); 
		
		String userName=article.getStr("user_name");
		User user=User.dao.findFirst("select * from cms_user where name=?", userName);
		long userId=user.getLong("id");
		long departId=user.getLong("depart_id");
		
		Depart depart=Depart.dao.findById(departId);
		String departName=depart.getStr("name");
		
		article.set("categroy_name", categroyName);
		article.set("user_id", userId);
		article.set("depart_id", departId);
		article.set("depart_name", departName);
		article.save();	
	}
}
