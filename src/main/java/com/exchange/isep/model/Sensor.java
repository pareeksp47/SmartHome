/**
 * 
 */
package com.exchange.isep.model;

/**
 * @author SAURABH
 *
 */
public class Sensor {

	int id;
	String name;
	String status;
	
	public Sensor(int id, String name, String status){
		
		this.id = id;
		this.name =  name;
		this.status = status;
		
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
}
