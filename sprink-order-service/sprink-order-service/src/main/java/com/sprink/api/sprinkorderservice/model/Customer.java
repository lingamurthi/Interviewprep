package com.sprink.api.sprinkorderservice.model;

import java.util.List;

import javax.persistence.*;
@Entity
public class Customer {
	    @Id
	    @GeneratedValue
	    private int id;
	    private String name;
	    private String email;
	    private String gender;
	    @OneToMany(targetEntity = OrderItemLunch.class,cascade=CascadeType.ALL)
	    @JoinColumn(name="cp_fk",referencedColumnName="id")
	    private List<OrderItemLunch> orders;
	
	    public Customer()
	    {
	    	
	    }
	    
		public Customer(int id, String name, String email, String gender, List<OrderItemLunch> orders) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.gender = gender;
			this.orders = orders;
		}
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public List<OrderItemLunch> getOrders() {
			return orders;
		}
		public void setOrders(List<OrderItemLunch> orders) {
			this.orders = orders;
		}
	    
	    
	    
	    
}
