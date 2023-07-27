package com.springproject.ClothingEcommerce.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	//Many to One means many product(shirt,pant) in one category(man)
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	private String prod_name;
	private Double prod_price;
	private String prod_code;
	private String prod_description;
	private int prod_quantity;	
	private String imageName;
}
