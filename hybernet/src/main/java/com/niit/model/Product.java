
package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Product {
	@Id
	
	private String id;
	
	private String name;
	
	private String description;
	
	
	private String Price;
	
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setPrice(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
