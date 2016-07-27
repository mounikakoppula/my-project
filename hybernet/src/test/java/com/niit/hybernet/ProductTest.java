package com.niit.hybernet;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;




public class ProductTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.hybernet");
		context.refresh();
		
		ProductDAO ProductDAO=(ProductDAO) context.getBean("ProductDAO");
		Product Product=(Product)context.getBean("product");
		Product.setId("pro11");
		Product.setName("god");
		Product.setDescription("good");
		Product.setPrice(1000);
		ProductDAO.saveOrUpdate(Product);
		
		ProductDAO.delete("pro_11");
		ProductDAO.get("pro_11");
		
		List<Product> list = ProductDAO.list();
		 for(Product Pro:list)
		 {
			 System.out.println(Pro.getId() +":" + Pro.getName()  +":"+ Pro.getDescription()  +":"+ getPrice());
		 }
		       context.close();
		

		

	
	}

	private static String getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

}