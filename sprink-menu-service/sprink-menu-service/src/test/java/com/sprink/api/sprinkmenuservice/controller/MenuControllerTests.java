package com.sprink.api.sprinkmenuservice.controller;



import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.sprink.api.sprinkmenuservice.model.CuisineType;
import com.sprink.api.sprinkmenuservice.model.MealSession;
import com.sprink.api.sprinkmenuservice.model.MenuItem;
import com.sprink.api.sprinkmenuservice.model.MenuItemType;
import com.sprink.api.sprinkmenuservice.model.PortionSize;
import com.sprink.api.sprinkmenuservice.repository.MenuItemRepository;
import com.sprink.api.sprinkmenuservice.service.MenuItemService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuControllerTests {

	 @Autowired
	 TestRestTemplate restTemp;
	

	@Autowired
	MenuItemService menuItemService;
	

	private static List<MenuItem> menuItems = new ArrayList<>();
	
	
	
	@BeforeEach
    public void setup() throws SQLException {
        // Initialize Test data
		
		
		MenuItem menuItem= new MenuItem();
		menuItem.setName("Idli");
		menuItem.setDescription("Idli");
		menuItem.setPrice(120);
		menuItem.setMenuItemType(MenuItemType.VEG);
		menuItem.setCuisineType(CuisineType.SOUTH);
		menuItem.setMealSession(MealSession.DINNER);
		menuItem.setPortionSize(PortionSize.STANDARD);
		menuItem.setCreatedTime(LocalDateTime.now());
		menuItem.setCreatedBy("");
		menuItem.setUpdatedTime(LocalDateTime.now());
		menuItem.setUpdatedBy("");

		menuItems.add(menuItem);
		menuItemService.createMenuItem(menuItem);
		
		
  
    }
	
	
	
	   @AfterEach
	    public void cleanup() {
		   
		    menuItems.clear();
		   
	    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   @Test
	    public void shouldCreateMenuItems() throws URISyntaxException
	    {
	        // POST /products

	    
//	        Mockito.when(menuItemService.createMenuItem(new MenuItem())).thenReturn("MenuItems is created successfully");

	        String reqBody = "{\"name\":\"Idli\",\"description\":\"Idli\",\"price\":\"120.0\",\"menuItemType\":\"VEG\",\"cuisineType\":\"SOUTH\",\"mealSession\":\"DINNER\",\"portionSize\":\"STANDARD\",\"createdTime\":\"\",\"createdBy\":\"\",\"updatedTime\":\"\",\"updatedBy\":\"\"}";


	        // Step 1: Create Request
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/MenuItems"));

	        // Step 2: Send Request to Endpoint
	        // Step 3: Receive the Response

	        ResponseEntity<String> response = restTemp.exchange(request, String.class);

	        System.out.println("Response: " + response.getBody());

	        // Step 4: Validate the Response
	        Assertions.assertThat(response).isNotNull();
	        Assertions.assertThat(response.getBody()).isEqualTo("MenuItems is created successfully");
	    }
	   
	   
	   
	   @Test
	    public void shouldReturnAllMenuItems() {

//	        Mockito.when(productService.getProducts()).thenReturn(products);

	        // REST Template
	        // Step 1: Create Request
	        // Step 2: Send Request to Endpoint
	        // Step 3: Receive the Response
	        ResponseEntity<Object> response = restTemp.getForEntity("/MenuItems", Object.class);

	        List<MenuItem> menuitems = (List) response.getBody();

	        System.out.println("Response: " + menuitems);

	        // Step 4: Validate the Response
	        Assertions.assertThat(response).isNotNull();
	        Assertions.assertThat(menuitems.size()).isEqualTo(2);
	      
	    }
}
