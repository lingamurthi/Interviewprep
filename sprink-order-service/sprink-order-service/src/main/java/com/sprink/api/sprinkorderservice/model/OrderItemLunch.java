package com.sprink.api.sprinkorderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;



@Entity
public class OrderItemLunch {


	@Id
	@Column(name="id")
	private int id;
	@Column(name="cuisineType")
	private CuisineType cuisineType;
	@Column(name="portionSize")
	private PortionSize portionSize;
	@Column(name="menuItemType")
	private MenuItemType menuItemType;
	@Column(name="price")
	private double price;

	
	public OrderItemLunch()
	{
		
	}
	
	
	public OrderItemLunch(int id, CuisineType cuisineType, PortionSize portionSize, MenuItemType menuItemType,
			double price) {
		super();
		this.id = id;
		this.cuisineType = cuisineType;
		this.portionSize = portionSize;
		this.menuItemType = menuItemType;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CuisineType getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}
	public PortionSize getPortionSize() {
		return portionSize;
	}
	public void setPortionSize(PortionSize portionSize) {
		this.portionSize = portionSize;
	}
	public MenuItemType getMenuItemType() {
		return menuItemType;
	}
	public void setMenuItemType(MenuItemType menuItemType) {
		this.menuItemType = menuItemType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	
}
