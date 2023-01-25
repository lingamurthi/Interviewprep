package com.sprink.api.sprinkorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprink.api.sprinkorderservice.model.OrderItemLunch;

@Repository
public interface OrderRepository extends JpaRepository<OrderItemLunch, Integer> {

}
