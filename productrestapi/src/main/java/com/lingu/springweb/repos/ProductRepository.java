package com.lingu.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lingu.springweb.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
