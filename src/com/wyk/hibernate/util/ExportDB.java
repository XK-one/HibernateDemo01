package com.wyk.hibernate.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {

	public static void main(String[] args) {
		
		//使用hibernate相关类configuation.  
        //默认读取hibernate.cfg.xml文件.
		Configuration configure = new Configuration().configure();
		//接受配置文件.
		SchemaExport export = new SchemaExport(configure);
		//打印到控制台,输出到数据库. 
		export.create(true, true); 
	}
	
}
