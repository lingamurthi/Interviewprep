package com.sprink.api.sprinkmenuservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;


import lombok.Data;

@Entity
public class MenuItem {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private double price;
	@Column(name="menuItemType")
	private MenuItemType menuItemType;
	@Column(name="cuisineType")
	private CuisineType cuisineType;
	@Column(name="mealSession")
	private MealSession mealSession;
	@Column(name="portionSize")
	private PortionSize portionSize;
	@Column(name="createdTime")
	private LocalDateTime createdTime;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="updatedTime")
	private LocalDateTime updatedTime;
	@Column(name="updatedBy")
	private String updatedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public MenuItemType getMenuItemType() {
		return menuItemType;
	}
	public void setMenuItemType(MenuItemType menuItemType) {
		this.menuItemType = menuItemType;
	}
	public CuisineType getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}
	public MealSession getMealSession() {
		return mealSession;
	}
	public void setMealSession(MealSession mealSession) {
		this.mealSession = mealSession;
	}
	public PortionSize getPortionSize() {
		return portionSize;
	}
	public void setPortionSize(PortionSize portionSize) {
		this.portionSize = portionSize;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
	
	
	
}
