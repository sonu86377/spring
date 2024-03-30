package org.jsp.jdbctemplatepractice;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FetchEmployees {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String qry = "select * from employee";
//		ResultSetExtractor<String> rse = rs -> {
//			while (rs.next()) {
//				System.out.println("Employee Id:" + rs.getInt(1));
//				System.out.println("Employee Name:" + rs.getString(2));
//				System.out.println("Salary:" + rs.getDouble(3));
//				System.out.println("Designation:" + rs.getString(4));
//			}
//			return "Employee details printed";
//		};
		String message = template.query(qry, new ResultSetExtractorImpl());
		System.out.println(message);
		((ClassPathXmlApplicationContext) context).close();
	}
}

class ResultSetExtractorImpl implements ResultSetExtractor<String> {

	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			System.out.println("Employee Id:" + rs.getInt(1));
			System.out.println("Employee Name:" + rs.getString(2));
			System.out.println("Salary:" + rs.getDouble(3));
			System.out.println("Designation:" + rs.getString(4));
		}
		return "Employee details printed";
	}

}
