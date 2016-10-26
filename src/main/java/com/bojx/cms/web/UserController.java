package com.bojx.cms.web;



import com.bojx.cms.model.Article;
import com.bojx.cms.render.VelocityLayoutRender;
import com.bojx.cms.service.UserService;
import com.jfinal.log.Log4jLog;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.render.JsonRender;

/**
 * 
 * @author syh
 * user module
 */
public class UserController extends BaseController {
	
	public static final Log4jLog LOG=Log4jLog.getLog(UserController.class);
	public static UserService userService=new UserService();
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
	   Record result=new Record();
	   try {
		   Article article=new Article();
		   article.set("categroy_id", getParaToLong("categroy_id"));
		   article.set("title", getPara("title"));
		   article.set("content", getPara("content"));
		   article.set("user_name", getCookie("username"));
		   userService.save(article);
		   result.set("code", "00");
		   result.set("msg","提交成功");
		   render(new JsonRender(result).forIE());
	   } catch (Exception e) {
		   LOG.error(e.getMessage(), e);
		   result.set("code", "06");
		   result.set("msg", e.getMessage());
		   render(new JsonRender(result).forIE());
	   }
	   
	}
	
}
