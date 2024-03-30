package org.jsp.jdbctemplatepractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployee {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		int r = template.update("insert into employee values(1,'abc',55555,'Senior Java Developer')");
		System.out.println(r + " rows inserted");
		((ClassPathXmlApplicationContext) context).close();
	}
}
