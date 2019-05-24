/**
 * 
 */
package com.exchange.isep.model;

import java.util.List;

/**
 * @author SAURABH
 *
 */
public class Room {

	int id;
	String name;
	int apartmentId;
	String roomType;
	List<Sensor> sensors;
	
	public Room(int id, String name, int apartmentId, String roomType) {
		
		this.id = id;
		this.name = name;
		this.apartmentId = apartmentId;
		this.roomType = roomType;
	}
	
	/**
	 * @return the sensors
	 */
	public List<Sensor> getSensors() {
		return sensors;
	}
	/**
	 * @param sensors the sensors to set
	 */
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
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
	 * @return the apartmentId
	 */
	public int getApartmentId() {
		return apartmentId;
	}
	/**
	 * @param apartmentId the apartmentId to set
	 */
	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}
	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", apartmentId=" + apartmentId + ", roomType=" + roomType + ", sensors=" + sensors + "]";
	}
	
	
}
