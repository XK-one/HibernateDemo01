package com.wyk.hibernate.controller;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.wyk.hibernate.entity.User;
/**
 * 先执行ExportDB类，再执行Client类
 */
public class Client {

	public static void main(String[] args) {
		//默认读取的是hibernate.cfg.xml 文件.  
		Configuration configure = new Configuration().configure();
		//建立SessionFactory.
		SessionFactory factory = configure.buildSessionFactory();
		
		/**Session是Hibernate运作的核心，对象的声明周期、事务的管理以及数据库的存取都与它息息相关*/
		Session session = null;
		
		try {
			//获取会话
			session = factory.openSession();
			//开启事务
			session.beginTransaction();
			
			//创建对象
			User user = new User();
			user.setName("张三1");  
            user.setPassword("123");  
            user.setCreateTime(new Date());  
            user.setExpireTime(new Date());  
            //保存user对象到数据库
            session.save(user);
			//提交事务
			session.getTransaction().commit();
		}catch(Exception e){
			//事务进行回滚
			session.getTransaction().rollback();
		}finally{
			if(session != null){
				if(session.isOpen()){
					//关闭session.  
                    //hibernate中已经将connection的的关闭封装了.  
                    //我们没有看到任何一条sql语句.
					session.close();
				}
			}
			
		}
		
	}
}
