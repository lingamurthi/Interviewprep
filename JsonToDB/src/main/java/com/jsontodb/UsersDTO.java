package com.jsontodb;



public class UsersDTO {
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String phone;

	private String birthday;

	private String website;
	
	private String image;
	
	private AddressDTO address;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddressDTO(AddressDTO address) {
		this.address = address;
	}

}
