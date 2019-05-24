/**
 * 
 */
package com.exchange.isep.model;

import java.util.List;

/**
 * @author SAURABH
 *
 */
public class Apartment {
	
	int id;
	String name;
	int userId;
	String apartmentRole;
	String houseName;
	String street;
	String city;
	String country;
	String zipCode;
	List<Room> rooms;
	
	public Apartment(int id, String name, int userId, String houseName, String street, String city, String country, String zipCode) {
		
		this.id = id;
		this.name	= name;
		this.userId = userId;
		this.houseName = houseName;
		this.street =  street;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	/**
	 * @return the rooms
	 */
	public List<Room> getRooms() {
		return rooms;
	}
	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the apartmentRole
	 */
	public String getApartmentRole() {
		return apartmentRole;
	}
	/**
	 * @param apartmentRole the apartmentRole to set
	 */
	public void setApartmentRole(String apartmentRole) {
		this.apartmentRole = apartmentRole;
	}
	/**
	 * @return the houseName
	 */
	public String getHouseName() {
		return houseName;
	}
	/**
	 * @param houseName the houseName to set
	 */
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Apartment [id=" + id + ", name=" + name + ", userId=" + userId + ", apartmentRole=" + apartmentRole
				+ ", houseName=" + houseName + ", street=" + street + ", city=" + city + ", country=" + country
				+ ", zipCode=" + zipCode 
				+ ", rooms=" + rooms + "]";
	}
	
	

}
