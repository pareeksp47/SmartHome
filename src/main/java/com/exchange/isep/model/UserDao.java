package com.exchange.isep.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	
	public static User getUserById(int id) {
		String query = String.format("Select * from users where ID = '%s'", id);

		Connection conn = ConnectionHelper.createConnection();
		if(conn == null)
			return new User(0, "", "", "", null, false, "", "", "");
		Statement st = null;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				
				User user = new User(rs.getInt("ID"), 
						rs.getString("First_Name"), 
						rs.getString("Last_Name"), 
						rs.getString("Email"), 
						null, 
						false, 
						rs.getString("User_Role"), 
						rs.getString("Password"), 
						"");
		      return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return null;
	}
	
	public static int update(User user) {
		
		String query = String.format("UPDATE users "
				+ "SET Password = '%s', First_Name = '%s',  Last_Name = '%s', Email = '%s'"
				+ "WHERE ID = '%s'", user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getId());
		Connection conn = ConnectionHelper.createConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			if(st.execute(query)) {
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}

}
