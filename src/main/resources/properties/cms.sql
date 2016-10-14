CREATE TABLE `cms_article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `categroy_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '栏目ID',
  `category_name` varchar(50) NOT NULL DEFAULT '' COMMENT '栏目名',
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '标题',
  `content` mediumtext  NOT NULL  COMMENT '内容',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `depart_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '部门ID',
  `depart` varchar(20) NOT NULL DEFAULT '' COMMENT '部门名',
  `is_enabled` char(1) NOT NULL DEFAULT 'N' COMMENT '是否启用',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_cms_categroy_id` (`categroy_id`),
  KEY `idx_cms_user_id` (`user_id`),
  KEY `idx_cms_depart_id` (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '文章表';

CREATE TABLE `cms_article_pic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `article_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '文章ID',
  `url` varchar(500) NOT NULL DEFAULT '' COMMENT '访问路径',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_cms_article_id` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '文章图片表';


CREATE TABLE `cms_article_attach` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `article_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '文章ID',
  `folder` varchar(500) NOT NULL DEFAULT '' COMMENT '文件路径',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_cms_article_id` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '文章附件表';

CREATE TABLE `cms_categroy` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '栏目名',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '栏目表';

CREATE TABLE `cms_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `depart_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '部门ID',
  `roles_ids` varchar(50)  NOT NULL DEFAULT '' COMMENT '角色ID',
  `is_locked` char(1)  NOT NULL DEFAULT 'N' COMMENT '是否锁定',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_cms_depart_id` (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户表';

CREATE TABLE `cms_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名',
  `perm_ids` varchar(50)  NOT NULL DEFAULT '' COMMENT '权限ID',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '角色表';

CREATE TABLE `cms_perm` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名',
  `action` varchar(50)  NOT NULL DEFAULT '' COMMENT '控制器',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '权限表';

CREATE TABLE `cms_depart` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '部门名称',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '部门表';

CREATE TABLE `cms_question` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '标题',
  `desc`  text NOT NULL  COMMENT '描述',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `depart_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '部门ID',
  `depart_name` varchar(20) NOT NULL DEFAULT '' COMMENT '部门名称',
   `display`  char(1) NOT NULL DEFAULT 'N' COMMENT '是否显示',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '问题表';

CREATE TABLE `cms_answer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `question_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '问题ID',
  `desc`  text NOT NULL  COMMENT '描述',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `depart_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '部门ID',
  `depart_name` varchar(20) NOT NULL DEFAULT '' COMMENT '部门名称',
  `display`  char(1) NOT NULL DEFAULT 'N' COMMENT '是否显示',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_cms_question_id` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '回答问题表';