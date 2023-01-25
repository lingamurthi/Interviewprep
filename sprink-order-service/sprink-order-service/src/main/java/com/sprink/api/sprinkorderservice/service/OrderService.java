package com.sprink.api.sprinkorderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sprink.api.sprinkorderservice.dto.OrderRequest;
import com.sprink.api.sprinkorderservice.dto.OrderResponse;
import com.sprink.api.sprinkorderservice.exception.OrderNotFoundException;
import com.sprink.api.sprinkorderservice.model.Customer;
import com.sprink.api.sprinkorderservice.model.OrderItemLunch;
import com.sprink.api.sprinkorderservice.model.ResponseMessage;

public interface OrderService {
	public OrderItemLunch createOrder(OrderItemLunch orderItemLunch);
	
	public List<OrderItemLunch> getAllOrder() throws OrderNotFoundException;
	
	public Optional<OrderItemLunch> getOderItems(int id) throws OrderNotFoundException;
	
	public OrderItemLunch updateOderItems(OrderItemLunch orderItemLunch, int id) throws OrderNotFoundException;
	
	public void deleteOderItems(@PathVariable int id) throws OrderNotFoundException;
	
	
	public Customer placeOrd(OrderRequest request);
	
	
	public List<Customer> findAllOrd();
	
	public List<OrderResponse> getJoinInfo();

	

}
