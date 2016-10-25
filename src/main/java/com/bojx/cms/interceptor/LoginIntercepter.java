package com.bojx.cms.interceptor;


import com.bojx.cms.util.EncryptUtil;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
/**
 * 
 * @author syh
 * this inteceptor is used to check login
 *
 */
public class LoginIntercepter implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
	  Controller controller=inv.getController();
	  String username=controller.getCookie("username");
	  String ssid=controller.getCookie("ssid");
	  if(username==null || ssid==null ||!EncryptUtil.md5(username).equals(ssid)){
		  controller.redirect("/login/index?sendURL="+controller.getRequest().getRequestURI());
	  }else{
		  inv.invoke();
	  }
	 
	}
}
