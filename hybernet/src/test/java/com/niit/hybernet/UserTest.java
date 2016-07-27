package com.niit.hybernet;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserTest {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");
		user.setId("12345");
		user.setName("mouni");
		user.setPassword("user_p");
		user.setMobile("900000000");
		user.setMail("mouni@gmail.com");
		user.setAddress("mbnr");
		userDAO.saveOrUpdate(user);
		
		userDAO.delete("US_1");
		userDAO.get("US_1");
	
		List<User>  list =    userDAO.list();
		
		for(User us : list)
		{
			System.out.println(us.getId()  + ":" +  us.getName()  + ":"+  us.getPassword()  +":"+ us.getMobile() +":"+ us.getMail() +":"+ us.getAddress());
		}
			
			
		context.close();
		
	}
}
