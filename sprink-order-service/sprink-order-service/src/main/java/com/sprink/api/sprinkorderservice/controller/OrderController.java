package com.sprink.api.sprinkorderservice.controller;


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
import org.springframework.web.bind.annotation.RestController;

import com.sprink.api.sprinkorderservice.dto.OrderRequest;
import com.sprink.api.sprinkorderservice.dto.OrderResponse;
import com.sprink.api.sprinkorderservice.exception.OrderNotFoundException;
import com.sprink.api.sprinkorderservice.model.Customer;
import com.sprink.api.sprinkorderservice.model.OrderItemLunch;
import com.sprink.api.sprinkorderservice.model.ResponseMessage;

import com.sprink.api.sprinkorderservice.service.OrderService;



@RestController
@RequestMapping("/order")
@CrossOrigin(value = "http://localhost:4200")
public class OrderController {
    
	
	@Autowired
	OrderService orderService;
	
	
	@PostMapping
	public ResponseMessage createOrder(@RequestBody OrderItemLunch orderItemLunch)
	{
		OrderItemLunch orders=orderService.createOrder(orderItemLunch);
		ResponseMessage responseMessage= new ResponseMessage();
		responseMessage.setStatus("success");
		responseMessage.setMessage("Oder Item  Created Successfully");
		return responseMessage;

	}
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request)
	{
		return orderService.placeOrd(request);
	}
	
	
	
    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
    	return orderService.findAllOrd();
    }
    
    
    
    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
    	return orderService.getJoinInfo();
    }
	
	@GetMapping
	public List<OrderItemLunch> getAllOrder() throws OrderNotFoundException
	{
		return orderService.getAllOrder();
		
	}
	
	

	@GetMapping("/{id}")
	public Optional<OrderItemLunch> getOderItems(@PathVariable int id) throws OrderNotFoundException
	{
		return orderService.getOderItems(id);
	}
	
	@PutMapping("/{id}")
	public OrderItemLunch updateOderItems(@RequestBody OrderItemLunch orderItemLunch, @PathVariable int id) throws OrderNotFoundException
	{
		
		OrderItemLunch item= orderService.updateOderItems(orderItemLunch, id);
		ResponseMessage responseMessage= new ResponseMessage();
		responseMessage.setStatus("success");
		responseMessage.setMessage("Oder Item  Updated Successfully");
		
		return item;
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseMessage deleteOderItems(@PathVariable int id) throws OrderNotFoundException
	{
		orderService.deleteOderItems(id);
		ResponseMessage response= new ResponseMessage();
		response.setStatus("success");
		response.setMessage("Oder Item  Deleted Successfully");
		
		return response;
	}
	
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleNoMenuItemException(OrderNotFoundException e)
	{
		ResponseMessage response=new ResponseMessage();
		response.setStatus("Failure");
		response.setMessage(e.getMessage());
		return (ResponseEntity<ResponseMessage>) ResponseEntity.badRequest().body(response);
	}
}
