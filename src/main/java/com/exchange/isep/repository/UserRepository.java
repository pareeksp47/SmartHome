/**
 * 
 */
package com.exchange.isep.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exchange.isep.model.User;

/**
 * @author SAURABH
 * Used for add, create, delete, retrieve users
 */
@Repository
public class UserRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  // find all users
  // haven't used limit as the application is used for smaller group of users. 
  public List < User > findAll() {

    List < User > result = jdbcTemplate.query(
      "SELECT id, first_name,last_name, email, created_on, status, user_role,password,gender FROM Users",
      (rs, rowNum) -> new User(rs.getInt("id"),
        rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getDate("created_on"), rs.getBoolean("status"), rs.getString("user_role"), rs.getString("password"), rs.getString("gender"))
    );

    return result;

  }

  // Add new user
  /**
   * 
   * @param user
   */
  public void addCustomer(User user) {

    jdbcTemplate.update("INSERT INTO users(first_name,last_name, email, password, status, user_role, created_on,gender) VALUES (?,?,?,?,?,?,?,?)",
      user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.isStatus(), user.getUserRole(), user.getCreatedOn(), user.getGender());

  }

  // Add new admin user
  public void addAdmin(User user) {

    jdbcTemplate.update("INSERT INTO users(first_name,last_name, email, password, status, user_role, created_on) VALUES (?,?,?,?,?,?,?)",
      user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.isStatus(), user.getUserRole(), user.getCreatedOn());

  }

  // Get Authenticated user details 
  public User authenticate(String userName, String password) throws Exception {
    List < User > result = jdbcTemplate.query(
      "SELECT id, first_name,last_name, email, created_on, status, user_role,password,gender FROM Users where email = ? and password = ? ",
      (rs, rowNum) -> new User(rs.getInt("id"),
        rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getDate("created_on"), rs.getBoolean("status"), rs.getString("user_role"), rs.getString("password"), rs.getString("gender")),
      new Object[] {
        userName,
        password
      }
    );

    return result.size() == 0 ? null : result.get(0);
  }

  // delete the user
  public void deleteUser(int id) {

    jdbcTemplate.update("DELETE from Users where id = ? ", id);

  }

  // update the user
  public void updateUser(String email, String password) {

    jdbcTemplate.update("UPDATE users SET password = ? WHERE email= ?", password, email);
  }
  
//update the user
 public void updateUser(User user) {

   jdbcTemplate.update("UPDATE users " + 
   		"				+ \"SET Password = ?', First_Name = ?,  Last_Name = ?, Email = ?" + 
   		"				+ \"WHERE Id = ?", new Object[] {user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getId()});
 }

 // get single user by id
  public User getUserById(int userId) {
    return (User) jdbcTemplate.query("Select * from users where ID = ?", 
        (rs, rowNum) -> new User(rs.getInt("id"),
          rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getDate("created_on"), rs.getBoolean("status"), rs.getString("user_role"), rs.getString("password"), rs.getString("gender")), new Object[] {userId});
    }
  }