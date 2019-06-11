package com.exchange.isep.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApartmentDao {

	public static Apartment getAppartmentByUserId(int userId) {


		String query = String.format("Select * from apartment where User_Id = '%s'", userId);

		Connection conn = ConnectionHelper.createConnection();
		if(conn == null)
			return new Apartment(0, "", 0, "", "", "", "", "");
		Statement st = null;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				Apartment apartment = new Apartment(rs.getInt("ID"),
						rs.getString("Name"),
						rs.getInt("User_Id"),
						rs.getString("House_Name"),
						rs.getString("Street"),
						rs.getString("City"),
						rs.getString("Country"),
						rs.getString("Zipcode"));
				return apartment;
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

		return new Apartment(0, "", 0, "", "", "", "", "");
	}

	public static int update(Apartment appt) {
		String query = String.format("UPDATE apartment "
				+ "SET Street = '%s', City = '%s',  Zipcode = '%s'"
				+ "WHERE ID = '%s'", appt.getStreet(), appt.getCity(), appt.getZipCode(), appt.getId());
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
