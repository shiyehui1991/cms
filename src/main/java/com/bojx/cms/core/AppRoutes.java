package com.bojx.cms.core;



import com.bojx.cms.web.LoginController;
import com.bojx.cms.web.TestController;
import com.jfinal.config.Routes;

public class AppRoutes extends Routes {

	@Override
	public void config() {
		add("test", TestController.class, "test");
		add("/",LoginController.class);
	}
	
}
