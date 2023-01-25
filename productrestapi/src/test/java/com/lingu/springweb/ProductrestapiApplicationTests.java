package com.lingu.springweb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.lingu.springweb.entities.Product;


@SpringBootTest
class ProductrestapiApplicationTests {
	
	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	void testGetProduct() {
		System.out.println(baseURL);
		RestTemplate restTemplate= new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"1", Product.class);
		assertNotNull(product);
		assertEquals("IPhone",product.getName());
	}
	
	@Test
	void testCreateProduct() {
		RestTemplate restTemplate= new RestTemplate();
		Product product= new Product();
		product.setName("Samsung Mobile");
		product.setDescription("Cool phone");
		product.setPrice(500);
		
		Product newProduct = restTemplate.postForObject(baseURL, product, Product.class);
		
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung Mobile", newProduct.getName());
	}
	
	
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate= new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"1", Product.class);
		product.setPrice(14000);
		restTemplate.put(baseURL, product);
	}

}
