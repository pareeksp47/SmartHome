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
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	/**
	 *  
	 * @return
	 */
    public List<User> findAll() {

    	
    	
        List<User> result = jdbcTemplate.query(
                "SELECT id, first_name,last_name, email, created_on, status, user_role,password,gender FROM Users",
                (rs, rowNum) -> new User(rs.getInt("id"),
                        rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getDate("created_on")
                        ,rs.getBoolean("status"), rs.getString("user_role"), rs.getString("password"),rs.getString("gender"))
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
                user.getFirstName(), user.getLastName(), user.getEmail(),user.getPassword(),user.isStatus(),user.getUserRole(),user.getCreatedOn(),user.getGender());

    }
    
    public void addAdmin(User user) {

        jdbcTemplate.update("INSERT INTO users(first_name,last_name, email, password, status, user_role, created_on) VALUES (?,?,?,?,?,?,?)",
                user.getFirstName(), user.getLastName(), user.getEmail(),user.getPassword(),user.isStatus(),user.getUserRole(),user.getCreatedOn());

    }

	public User authenticate(String userName, String password)throws Exception {
		List<User> result = jdbcTemplate.query(
                "SELECT id, first_name,last_name, email, created_on, status, user_role,password,gender FROM Users where email = ? and password = ? ",
                new Object[] {userName,password},(rs, rowNum) -> new User(rs.getInt("id"),
                        rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getDate("created_on")
                        ,rs.getBoolean("status"), rs.getString("user_role"), rs.getString("password"),rs.getString("gender"))
        );
		
        return result.size() == 0 ? null : result.get(0) ;
	}
	
	public void deleteUser(int id) {
		
		jdbcTemplate.update("DELETE from Users where id = ? ", id);
		
	}

public void updateUser(String email, String password) {
	System.out.println("email :"+email+ "-----   "+"password : "+password);
	
	
	jdbcTemplate.update("UPDATE users SET password = ? WHERE email= ?",password, email );
}

}
