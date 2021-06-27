package com.exchange.isep.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exchange.isep.model.Apartment;

@Repository
public class ApartmentDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * Get apartment by user id
   * @param userId
   * @return
   * @throws Exception
   */
  public Apartment getAppartmentByUserId(int userId) throws Exception {

    Apartment apartment = null;
    String query = "Select * from apartment where User_Id = ?";
    apartment = (Apartment) jdbcTemplate.query(query, (rs, rowNum) -> new Apartment(rs.getInt("ID"),
        rs.getString("Name"),
        rs.getInt("User_Id"),
        rs.getString("House_Name"),
        rs.getString("Street"),
        rs.getString("City"),
        rs.getString("Country"),
        rs.getString("Zipcode")),
      new Object[] {
        userId
      });

    return apartment;
  }

  /**
   * Update Apartment 
   * @param appt
   * @throws Exception
   */
  public void update(Apartment appt) throws Exception {

    String query = "UPDATE apartment " +
      "SET Street = '%s', City = '%s',  Zipcode = '%s'" +
      "WHERE ID = '%s'";
    jdbcTemplate.update(query, new Object[] {
      appt.getStreet(), appt.getCity(), appt.getZipCode(), appt.getId()
    });

  }
}