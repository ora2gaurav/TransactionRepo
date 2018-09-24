package org.java.jdbc.demo;

import org.java.jdbc.Dao.JdbcDao;
import org.java.jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
public static void main(String[] args) {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("file:src/Srping.xml");
	JdbcDao dao;
	try{
		dao=ctx.getBean("dao",JdbcDao.class);
	
		Employee emp=dao.getEmp(204);
	System.out.println(emp.getFIRST_NAME());
	}
	catch(Exception e){System.out.println(e.getMessage());}
	finally{
		((AbstractApplicationContext) ctx).close();
	}
		
}
}
