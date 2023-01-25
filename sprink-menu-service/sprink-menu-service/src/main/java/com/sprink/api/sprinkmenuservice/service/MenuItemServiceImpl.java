package com.sprink.api.sprinkmenuservice.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprink.api.sprinkmenuservice.exception.MenuItemNotFoundException;
import com.sprink.api.sprinkmenuservice.model.CuisineType;
import com.sprink.api.sprinkmenuservice.model.MealSession;
import com.sprink.api.sprinkmenuservice.model.MenuItem;
import com.sprink.api.sprinkmenuservice.model.PortionSize;
import com.sprink.api.sprinkmenuservice.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	
	
	@Autowired
	MenuItemRepository menuItemRepository;
	@Override
	public MenuItem createMenuItem(MenuItem item) throws SQLException{
		// TODO Auto-generated method stub
		item.setCreatedTime(LocalDateTime.now());
		//item.setCreatedTime(LocalDateTime.now());
		return menuItemRepository.save(item);
		
		
	}

	@Override
	public MenuItem updateMenuItem(MenuItem item, int id) throws MenuItemNotFoundException {
		Optional<MenuItem> itemOptional = menuItemRepository.findById(id);
		
		if(itemOptional.isEmpty())
		{
			throw new MenuItemNotFoundException("No menu item found" +" "+id);
		}
		
		item.setId(id);
		item.setUpdatedTime(LocalDateTime.now());
		return (MenuItem) menuItemRepository.save(item);
	}

	@Override
	public List<MenuItem> getMenuItems(){
		// TODO Auto-generated method stub
		return menuItemRepository.findAll();
	}

	
	
	
	@Override
	public List<MenuItem> getFilter(CuisineType cuisineType,MealSession mealSession, PortionSize portionSize)
	{
		return menuItemRepository.findByCuisineTypeAndMealSessionAndPortionSize(cuisineType,mealSession,portionSize);
	}
	

	 
	@Override
	public Optional<MenuItem> getMenuItem(int id) throws MenuItemNotFoundException{
		
	Optional<MenuItem> itemOptional = menuItemRepository.findById(id);
		
		if(itemOptional.isEmpty())
		{
			throw new MenuItemNotFoundException("No menu item found" +" " +id);
		}
		return itemOptional;
	}

	@Override
	public void deleteMenuItem(int id) throws MenuItemNotFoundException {
		// TODO Auto-generated method stub
		
		
		  Optional<MenuItem> itemOptional = menuItemRepository.findById(id);
	        if(itemOptional.isEmpty()) {
	            throw new MenuItemNotFoundException("No menu item found for given id - "+" " + id);
	        }
		menuItemRepository.deleteById(id);
		
	}
	@Override
	public void clear() {
		
		menuItemRepository.deleteAll();
	}
	

}
