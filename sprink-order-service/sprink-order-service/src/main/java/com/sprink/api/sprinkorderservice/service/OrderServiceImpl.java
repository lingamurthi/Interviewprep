package com.sprink.api.sprinkorderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprink.api.sprinkorderservice.dto.OrderRequest;
import com.sprink.api.sprinkorderservice.dto.OrderResponse;
import com.sprink.api.sprinkorderservice.exception.OrderNotFoundException;
import com.sprink.api.sprinkorderservice.model.Customer;
import com.sprink.api.sprinkorderservice.model.OrderItemLunch;
import com.sprink.api.sprinkorderservice.repository.CustomerRepository;
import com.sprink.api.sprinkorderservice.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public OrderItemLunch createOrder(OrderItemLunch orderItemLunch) {
		return orderRepository.save(orderItemLunch);
	}

	@Override
	public List<OrderItemLunch> getAllOrder() {
		
		return orderRepository.findAll();
	}

	@Override
	public Optional<OrderItemLunch> getOderItems(int id) throws OrderNotFoundException {
	Optional<OrderItemLunch> orderOptional = orderRepository.findById(id);
		
		if(orderOptional.isEmpty())
		{
			throw new OrderNotFoundException("No order item found" +id);
		}
		return orderOptional;
	}

	@Override
	public OrderItemLunch updateOderItems(OrderItemLunch orderItemLunch, int id) throws OrderNotFoundException {
		Optional<OrderItemLunch> order=orderRepository.findById(id);
		if(order.isEmpty())
		{
			throw new OrderNotFoundException("No order item found" +id);
		}
		return orderRepository.save(orderItemLunch);
		
		
	}

	@Override
	public void deleteOderItems(int id) {
		orderRepository.deleteById(id);
		
	}

	
	
	@Override
	public Customer placeOrd(OrderRequest request)
	{
		return customerRepository.save(request.getCustomer());
	}
	
	@Override
	public List<Customer> findAllOrd()
	{
		return customerRepository.findAll();
	}
	
	@Override
	public List<OrderResponse> getJoinInfo()
	{
		return customerRepository.getJoinInformation();
	}
}
