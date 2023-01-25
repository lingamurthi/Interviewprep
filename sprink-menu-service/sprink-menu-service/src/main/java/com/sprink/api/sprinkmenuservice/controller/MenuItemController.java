package com.sprink.api.sprinkmenuservice.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprink.api.sprinkmenuservice.exception.MenuItemNotFoundException;
import com.sprink.api.sprinkmenuservice.model.CuisineType;
import com.sprink.api.sprinkmenuservice.model.MealSession;
import com.sprink.api.sprinkmenuservice.model.MenuItem;
import com.sprink.api.sprinkmenuservice.model.PortionSize;
import com.sprink.api.sprinkmenuservice.model.ResponseMessage;
import com.sprink.api.sprinkmenuservice.service.MenuItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin(value = "http://localhost:4200")
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	@PostMapping
	public ResponseEntity<ResponseMessage> createMenuItem(@RequestBody MenuItem menuItem) throws SQLException, URISyntaxException {

		MenuItem item = menuItemService.createMenuItem(menuItem);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setStatus("success");
		responseMessage.setMessage("Menu Item  Created Successfully");
		// return (ResponseEntity<ResponseMessage>) ResponseEntity.created(new
		// URI("http://localhost:8081/aprink/api/items" +item.getId()));
		
		
		 ResponseEntity<ResponseMessage> res = ResponseEntity.created(new URI("http://localhost:8081/sprink/items/" + menuItem.getId())).body(responseMessage);
		return res;
	}

	@GetMapping
	public List<MenuItem> getAll() throws SQLException{
		return menuItemService.getMenuItems();
	}

	
	
	@GetMapping(value="/abc")
	public List<MenuItem> getFilterItem(@RequestParam("cuisineType")CuisineType cuisineType,@RequestParam("mealSession")MealSession mealSession,@RequestParam("portionSize")PortionSize portionSize)
	{
		return menuItemService.getFilter(cuisineType,mealSession,portionSize);
	}



	
	
	@GetMapping("/{id}")
	public Optional<MenuItem> getMenuItems(@PathVariable int id) throws MenuItemNotFoundException {
		return menuItemService.getMenuItem(id);
	}
	
	
	
	

	@PutMapping("/{id}")
	public MenuItem updateMenuItems(@RequestBody MenuItem menuItem, @PathVariable int id)
			throws MenuItemNotFoundException {

		MenuItem item = (MenuItem) menuItemService.updateMenuItem(menuItem, id);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setStatus("success");
		responseMessage.setMessage("Menu Item  Updated Successfully");

		return item;
	}

	@DeleteMapping("/{id}")
	public ResponseMessage deleteMenuItems(@PathVariable int id) throws MenuItemNotFoundException {
		menuItemService.deleteMenuItem(id);
		ResponseMessage response = new ResponseMessage();
		response.setStatus("success");
		response.setMessage("Menu Item  Deleted Successfully");

		return response;
	}

	@ExceptionHandler(MenuItemNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleNoMenuItemException(MenuItemNotFoundException e) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus("Failure");
		response.setMessage(e.getMessage());
		return (ResponseEntity<ResponseMessage>) ResponseEntity.badRequest().body(response);
	}
}
