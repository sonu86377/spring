package org.jsp.hibernatetemplatepractice.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hibernatetemplatepractice.dao.UserDao;
import org.jsp.hibernatetemplatepractice.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Find User By Id");
		System.out.println("4.Delete User By Id");
		System.out.println("5.Verify User By Phone and Password");
		System.out.println("6.Verify User By email and password");
		System.out.println("7.Verify User By Id and password");
		System.out.println("8.Find User By Phone");
		System.out.println("9.Find User By email");
		System.out.println("10.Find Users By name");
		Scanner sc = new Scanner(System.in);
		switch (sc.nextInt()) {
		case 1: {
			System.out.println("Enter the name, phone, email and password to save User");
			User user = new User();
			user.setName(sc.next());
			user.setPhone(sc.nextLong());
			user.setEmail(sc.next());
			user.setPassword(sc.next());
			user = userDao.saveUser(user);
			System.out.println("User saved with Id:" + user.getId());
			break;
		}
		case 2: {
			System.out.println("Enter the id, name, phone, email and password to save User");
			User user = new User();
			user.setId(sc.nextInt());
			user.setName(sc.next());
			user.setPhone(sc.nextLong());
			user.setEmail(sc.next());
			user.setPassword(sc.next());
			user = userDao.updateUser(user);
			if (user != null)
				System.out.println("User with Id:" + user.getId() + " Updated");
			else
				System.err.println("Cannot Update User as Id is Invalid");
			break;
		}
		case 3: {
			System.out.println("Enter the User Id to print details");
			User user = userDao.findById(sc.nextInt());
			if (user != null)
				System.out.println(user);
			else
				System.err.println("You have entered an Invalid User id");
			break;
		}
		case 4: {
			System.out.println("Enter the User Id to delete");
			boolean deleted = userDao.delete(sc.nextInt());
			if (deleted)
				System.out.println("User with entered id deleted");
			else
				System.err.println("cannot delete User as entered Id is Invalid");
			break;
		}
		case 5: {
			System.out.println("Enter the Phone number and password to verify user");
			User user = userDao.verifyUser(sc.nextLong(), sc.next());
			if (user != null) {
				System.out.println("Verification Succesfull");
				System.out.println(user);
			} else
				System.err.println("Invalid Phone Number or Password");
			break;
		}
		case 6: {
			System.out.println("Enter the Email Id and password to verify user");
			User user = userDao.verifyUser(sc.next(), sc.next());
			if (user != null) {
				System.out.println("Verification Succesfull");
				System.out.println(user);
			} else
				System.err.println("Invalid Email Id or Password");
			break;
		}
		case 7: {
			System.out.println("Enter the User Id and password to verify user");
			User user = userDao.verifyUser(sc.nextInt(), sc.next());
			if (user != null) {
				System.out.println("Verification Succesfull");
				System.out.println(user);
			} else
				System.err.println("Invalid User Id or Password");
			break;
		}
		case 8: {
			System.out.println("Enter the Phone number to find user");
			User user = userDao.findByPhone(sc.nextLong());
			if (user != null) {
				System.out.println("User Found");
				System.out.println(user);
			} else
				System.err.println("Invalid Phone Number");
			break;
		}
		case 9: {
			System.out.println("Enter the Email Id to find user");
			User user = userDao.findByEmail(sc.next());
			if (user != null) {
				System.out.println("User Found");
				System.out.println(user);
			} else
				System.err.println("Invalid Email Id");
			break;
		}
		case 10: {
			System.out.println("Enter the name to find users");
			List<User> users = userDao.findByName(sc.next());
			if (users.isEmpty())
				System.err.println("No User with entered name");
			else
				for (User user : users)
					System.out.println(user);
			break;
		}
		default: {
			sc.close();
			((ClassPathXmlApplicationContext) context).close();
			System.err.println("Invalid Choice");
		}
		}
	}
}
