package com.bojx.cms.validator;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.render.JsonRender;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		
		validateRequiredString("password", "msg", "请输入密码");
		validateRequiredString("username", "msg", "请输入用户名");
	}

	@Override
	protected void handleError(Controller c) {
		Record result=new Record();
		result.set("code","04");
		result.set("msg", c.getAttr("msg"));
		c.render(new JsonRender(result).forIE());		
	}

}
