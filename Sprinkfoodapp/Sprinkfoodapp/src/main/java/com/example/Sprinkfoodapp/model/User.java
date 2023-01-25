package com.example.Sprinkfoodapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User")
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@NotNull(message = "Username should not be null")
	@NotBlank(message = "Username should not be blank")
	@Column(name = "user")
	private String user;
	@Email(message="Email is not valid",regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	@NotNull(message = "Email should not be null")
	@NotBlank(message = "Email should not be blank")
	@Column(name = "email")
	private String email;
	@NotNull(message = "Password should not be null")
	@NotBlank(message = "Password should not be blank")
	@Column(name = "password")
	private String password;
	
	
	
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUsername(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + user + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
