package com.sprink.api.sprinkmenuservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprink.api.sprinkmenuservice.model.CuisineType;
import com.sprink.api.sprinkmenuservice.model.MealSession;
import com.sprink.api.sprinkmenuservice.model.MenuItem;
import com.sprink.api.sprinkmenuservice.model.PortionSize;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{

	
	public List<MenuItem> findByCuisineTypeAndMealSessionAndPortionSize(CuisineType cuisineType,MealSession mealSession,PortionSize portionSize);
}
