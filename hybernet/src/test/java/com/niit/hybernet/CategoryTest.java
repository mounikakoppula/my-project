package com.niit.hybernet;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@SuppressWarnings("unused")
public class CategoryTest {

@SuppressWarnings("resource")
public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		category.setId("1");
		category.setName("mnmn");
		category.setDescription("vij");
		categoryDAO.saveOrUpdate(category);
		
		
	}
}
