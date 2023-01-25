package com.sprink.api.sprinkorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprink.api.sprinkorderservice.dto.OrderResponse;
import com.sprink.api.sprinkorderservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	@Query("SELECT new com.sprink.api.sprinkorderservice.dto.OrderResponse(c.name,p.cuisineType,p.menuItemType,p.portionSize) FROM Customer c JOIN c.orders p")
	 public List<OrderResponse> getJoinInformation();
}
