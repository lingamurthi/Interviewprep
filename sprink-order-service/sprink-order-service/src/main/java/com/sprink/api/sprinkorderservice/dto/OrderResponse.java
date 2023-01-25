package com.sprink.api.sprinkorderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sprink.api.sprinkorderservice.model.CuisineType;
import com.sprink.api.sprinkorderservice.model.MenuItemType;
import com.sprink.api.sprinkorderservice.model.PortionSize;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {

	private String name;
	private CuisineType cuisineType;
	private MenuItemType menuItemType;
	private PortionSize portionSize;
	
	
	public OrderResponse()
	{
		
	}


	public OrderResponse(String name, CuisineType cuisineType, MenuItemType menuItemType, PortionSize portionSize) {
		super();
		this.name = name;
		this.cuisineType = cuisineType;
		this.menuItemType = menuItemType;
		this.portionSize = portionSize;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public CuisineType getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}


	public MenuItemType getMenuItemType() {
		return menuItemType;
	}


	public void setMenuItemType(MenuItemType menuItemType) {
		this.menuItemType = menuItemType;
	}


	public PortionSize getPortionSize() {
		return portionSize;
	}


	public void setPortionSize(PortionSize portionSize) {
		this.portionSize = portionSize;
	}
	

	

}
