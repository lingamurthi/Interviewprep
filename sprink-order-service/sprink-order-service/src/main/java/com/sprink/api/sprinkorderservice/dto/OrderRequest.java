package com.sprink.api.sprinkorderservice.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sprink.api.sprinkorderservice.model.Customer;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
    
	private Customer customer;


	public OrderRequest()
	{
		
	}
	public OrderRequest(Customer customer) {
		super();
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
