package com.sprink.api.sprinkmenuservice.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprink.api.sprinkmenuservice.exception.MenuItemNotFoundException;
import com.sprink.api.sprinkmenuservice.model.CuisineType;
import com.sprink.api.sprinkmenuservice.model.MealSession;
import com.sprink.api.sprinkmenuservice.model.MenuItem;
import com.sprink.api.sprinkmenuservice.model.MenuItemType;
import com.sprink.api.sprinkmenuservice.model.PortionSize;
import com.sprink.api.sprinkmenuservice.service.MenuItemService;

public class MenuServiceTests {

	
	@Autowired
	MenuItemService menuItemService;
	
	
	@BeforeAll
	public static void init() {
		// Logic to initialize test data goes here
		System.out.println("Test data initialization at class level..");
	}

	@AfterAll
	public static void tearDown() {
		// Logic to clean up test data goes here
		System.out.println("Test data clean up at class level..");
	}
	
	
	
	@BeforeEach
	public void setup() {
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

	
	}

	@AfterEach
	public void cleanup() {
		menuItemService.clear();
//		products.clear();
	}
	
	
	
	@Test
	public void shouldCreateMenuItemWhenPassingMandatoryDetails() throws MenuItemNotFoundException, SQLException {
		MenuItem menuItem= new MenuItem();

		
		MenuItem menuItem2= new MenuItem();
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
		menuItemService.createMenuItem(menuItem);

		assertNotNull(menuItemService.getMenuItem(3));
		assertEquals("3", menuItemService.getMenuItem(3));
	}
	
	
	
	@Test
	public void shouldShowErrorWhenNotPassingMandatoryDetails() {
		MenuItem menuItem= new MenuItem();
		try {
			menuItemService.createMenuItem(menuItem);
		} catch (Exception e) {
			assertEquals("menuItem Id mandatory", e.getMessage());
		}
	}
	
	
	@Test
	public void shouldUpdateMenuItemForGivenMenuItemId() throws MenuItemNotFoundException {
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

		menuItemService.updateMenuItem(menuItem,2);

		assertNotNull(menuItemService.getMenuItem(2));
		assertEquals("2", menuItemService.getMenuItem(2));
	}
	
	
	
	@Test
	public void shouldDeleteMenuItemWhenPassingValidMenuItemId() throws MenuItemNotFoundException {
		menuItemService.deleteMenuItem(2);
		assertNull(menuItemService.getMenuItem(2));
		assertEquals(1,menuItemService.getMenuItem(2));
	}
	
	
	
	@Test
	public void shouldReturnMenuItemForGivenMenuItemId() throws MenuItemNotFoundException {
//		Mockito.when(productRepo.findById("2")).thenReturn(Optional.of(products.get(1)));
		
		
		assertNotNull(menuItemService.getMenuItem(2));
		assertEquals("2", menuItemService.getMenuItem(2));
	}
	
	
	
	@Test
	public void shouldReturnAllMenuItemWhenDontSpecifyMenuItemId() throws MenuItemNotFoundException {
//		Mockito.when(productRepo.findAll()).thenReturn(products);
		
		assertEquals(2, menuItemService.getMenuItem(2));
	}
}
