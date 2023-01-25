package com.sprink.api.sprinkmenuservice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.sprink.api.sprinkmenuservice.exception.MenuItemNotFoundException;
import com.sprink.api.sprinkmenuservice.model.CuisineType;
import com.sprink.api.sprinkmenuservice.model.MealSession;
import com.sprink.api.sprinkmenuservice.model.MenuItem;
import com.sprink.api.sprinkmenuservice.model.PortionSize;



public interface MenuItemService {

	
	public MenuItem createMenuItem(MenuItem item) throws SQLException;
	public MenuItem updateMenuItem(MenuItem item,int id) throws MenuItemNotFoundException;
	public List<MenuItem> getMenuItems();
	
	public List<MenuItem> getFilter(CuisineType cuisineType,MealSession mealSession, PortionSize portionSize);
	
	public Optional<MenuItem> getMenuItem(int id) throws MenuItemNotFoundException;
	public void deleteMenuItem(int id) throws MenuItemNotFoundException;
	public void clear();
	
	
}
