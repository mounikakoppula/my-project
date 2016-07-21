package com.niit.hybernet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryTest {
	public static void main(String[] args){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.hybernet");
		context.refresh();
		CategoryDAO categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		Category category=(Category) context.getBean("category");
		category.setId("cg1200");
		category.setName("cgName");
		category.setDescription("cgdesc");
		categoryDAO.saveOrUpdate(category);
		if(categoryDAO.get ("sdsf")==null)
		{
			System.out.println("category does not exist");
		}
		else
		{
			System.out.println("category exist...the details are....");
			System.out.println();
			
		}
	}

}
