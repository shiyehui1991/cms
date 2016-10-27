package com.bojx.cms.core;


import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.bojx.cms.interceptor.LoginIntercepter;
import com.bojx.cms.model.Article;
import com.bojx.cms.model.Categroy;
import com.bojx.cms.model.Depart;
import com.bojx.cms.model.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;

public class AppConfig extends JFinalConfig {
	
	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("properties/appconfig.properties","UTF-8");
		me.setDevMode(getPropertyToBoolean("deMode"));
		me.setViewType(ViewType.VELOCITY);
		me.setMaxPostSize(50 * 1024 * 1024);// 上传的文件的最大50M
		me.setBaseViewPath("/WEB-INF/templates");
		me.setEncoding("UTF-8");
	}

	@Override
	public void configRoute(Routes me) {
		me.add(new AppRoutes());
	}

	@Override
	public void configPlugin(Plugins me) {
		DruidPlugin db = new DruidPlugin(getProperty("jdbc.url"), getProperty("jdbc.username"),getProperty("jdbc.password"));// 数据库连接插件
		db.addFilter(new StatFilter());// sql 监控
		WallFilter wall = new WallFilter();// 防止sql 注入
		wall.setDbType("mysql");
		db.addFilter(wall);
		me.add(db);
		
		ActiveRecordPlugin arp = new ActiveRecordPlugin(db);
		arp.setDialect(new MysqlDialect());
		arp.setShowSql(getPropertyToBoolean("deMode"));// 开发者模式下开启SQL
		me.add(arp);
		
		arp.addMapping("cms_article", Article.class);
		arp.addMapping("cms_categroy", Categroy.class);
		arp.addMapping("cms_user", User.class);
		arp.addMapping("cms_depart", Depart.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new LoginIntercepter());

	}

	@Override
	public void configHandler(Handlers me) {
		

	}

	@Override
	public void afterJFinalStart() {
		System.out.println("JFinal 启动了");
	}

	@Override
	public void beforeJFinalStop() {
		
	}
	
	
}
