package org.jsp.jdbctemplatepractice;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployee2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id, name, salary and designation to save Employee");
		int id = sc.nextInt();
		String name = sc.next();
		double salary = sc.nextDouble();
		String desg = sc.next();
		String sql = "insert into employee values(?,?,?,?)";
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		int r = template.update(sql, id, name, salary, desg);
		System.out.println(r + " rows inserted");
		((ClassPathXmlApplicationContext) context).close();
		sc.close();
	}
}
