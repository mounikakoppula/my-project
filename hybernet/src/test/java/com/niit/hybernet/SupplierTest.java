package com.niit.hybernet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;



public class SupplierTest {
	public static void main(String[] args){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.hybernet");
		context.refresh();
		SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier=(Supplier)context.getBean("supplier");
		supplier.setId("sg1200");
		supplier.setName("sgName");
		supplier.setDescription("sgdesc");
		supplierDAO.saveOrUpdate(supplier);
		if(supplierDAO.get ("sdsf")==null)
		{
			System.out.println("supplier does not exist");
		}
		else
		{
			System.out.println("supplier exist...the details are....");
			System.out.println();
			
		}
	}

}