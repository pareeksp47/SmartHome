/**
 * 
 */
package com.exchange.isep.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author SAURABH
 *
 */
@Repository
public class UserDashboardRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	

}
