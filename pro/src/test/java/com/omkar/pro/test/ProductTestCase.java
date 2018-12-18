package com.omkar.pro.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omkar.pro.dao.ProductDAO;
import com.omkar.pro.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.omkar.pro");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

//	@Test
//	public void testCRUDProduct() {
//		// create operation
//		product = new Product();
//
//		product.setName("Style");
//		product.setBrand("iBALL");
//		product.setDescription("This is some description");
//		product.setUnitPrice(200);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(2);
//
//		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
//
//		// reading and updating the category
//		product = productDAO.get(5);
//		product.setName("STYLE");
//		assertEquals("Something went wrong while updating the existing record!", true, productDAO.update(product));
//
//		assertEquals("Something went wrong while deleting the existing record!", true, productDAO.delete(product));
//
//		// list
//		assertEquals("Something went wrong while fetching the list of products!", 5, productDAO.list().size());
//	}
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				4,productDAO.listActiveProducts().size());				
	} 
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				1,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} 

}
