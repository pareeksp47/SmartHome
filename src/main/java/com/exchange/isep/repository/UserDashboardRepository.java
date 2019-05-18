/**
 * 
 */
package com.exchange.isep.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exchange.isep.model.Apartment;
import com.exchange.isep.model.Room;
import com.exchange.isep.model.Sensor;

/**
 * @author SAURABH
 *
 */
@Repository
public class UserDashboardRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Sensor> sensors(int roomId) throws Exception{
		
		List<Sensor> sensors = null;
		
		 sensors = jdbcTemplate.query(
                "SELECT * FROM Sensor where Room_Id = ?", new Object[] {roomId}, 
                (rs, rowNum) -> new Sensor(rs.getInt("id"),
                        rs.getString("name"), rs.getString("status"))
        );

        return sensors;
	}
	
	
	public List<Room> rooms(int apartmentId) throws Exception{
		
		List<Room> rooms = null;
		
		 rooms = jdbcTemplate.query(
               "SELECT * FROM Room where Apartment_Id = ? ", new Object[] {apartmentId},
               (rs, rowNum) -> new Room(rs.getInt("Id"),
                       rs.getString("Name"), rs.getInt("Apartment_id"),
               		   rs.getString("Room_Type"))
       );

       return rooms;
	}
	
	public List<Apartment> apartments(int userId) throws Exception{
		
		List<Apartment> apartments = null;
		
		 apartments = jdbcTemplate.query(
               "SELECT * FROM Apartment where user_id = ?", new Object[] {userId},
               (rs, rowNum) -> new Apartment(rs.getInt("id"),
                       rs.getString("name"), rs.getInt("User_Id"),
                       rs.getString("house_Name"),rs.getString("street"),
                       rs.getString("city"),rs.getString("country"),
                       rs.getString("ZipCode"))
       );

       return apartments;
	}

}
