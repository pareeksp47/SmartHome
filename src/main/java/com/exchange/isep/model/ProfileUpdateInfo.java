package com.exchange.isep.model;

public class ProfileUpdateInfo {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public int getApptId() {
		return apptId;
	}
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipcode;
	}
	public void setZipCode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	public User getUser() {
		User user = new User(id, firstName, lastName, email, null, false, "", password, "");
		return user;
	}
	
	public Apartment getApartment() {
		Apartment appt = new Apartment(apptId, "", id, "", street, city, country, zipcode);
		return appt;
	}
	
	
	
	
	private int id;
	private String lastName; 
	private String firstName; 
	private String email; 
	private String password; 
	
	private int apptId ;
	private String street;
	private String city;
	private String country;
	private String zipcode;
}
