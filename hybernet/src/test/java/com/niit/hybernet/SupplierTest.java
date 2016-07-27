package com.niit.hybernet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;




public class SupplierTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.hybernet");
		context.refresh();
		
		SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier=(Supplier)context.getBean("supplier");
		supplier.setId("227hyd");
		supplier.setName("product");
		supplier.setDescription("mouni");
		supplierDAO.saveOrUpdate(supplier);
		

		

	
	}

}