package com.bojx.cms.web;

import com.bojx.cms.render.VelocityLayoutRender;

/**
 * 
 * @author syh
 * user module
 */
public class UserController extends BaseController {
	

	public void index(){
		render("center.html");
	}
	
	public void center(){
		render("center.html");
	}
	
	public void newArticle(){
		render(new VelocityLayoutRender("editor.html"));
	}
	
	/**
	 * public article interface
	 */
	public void publish(){
	   
	}
	
}
