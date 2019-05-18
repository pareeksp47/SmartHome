/**
 * 
 */
package com.exchange.isep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exchange.isep.model.Apartment;
import com.exchange.isep.model.DashboardDetails;
import com.exchange.isep.model.Room;
import com.exchange.isep.model.Sensor;
import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserDashboardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author MANJUSREE
 *
 */
@Controller
public class UserDashboardController {
	
	@Autowired
	private UserDashboardRepository userDashboardRepository;

	@GetMapping({ "/userDashboard" })
	public String userDB(Model model) {
		return "userDashboard";
	}

	@RequestMapping(value="/userData", method = RequestMethod.GET)
	@ResponseBody
	public String userDashboardData(@RequestParam(value = "id") String id,
			HttpServletRequest request) {

		String result = "";
		try {

			HttpSession session = request.getSession(false);
			if(null != session) {

				User user = (User) session.getAttribute("user");
				if(null != user) {
					
					List<Apartment> apartments = userDashboardRepository.apartments(user.getId());
					for(Apartment apartment : apartments) {
						
						List<Room> rooms = userDashboardRepository.rooms(apartment.getId());
						apartment.setRooms(rooms);
						for(Room room : rooms) {
							
							List<Sensor> sensors = userDashboardRepository.sensors(room.getId());
							room.setSensors(sensors);
						}
					}
					
					ObjectMapper mapper = new ObjectMapper();
					DashboardDetails details = new DashboardDetails();
					details.apartments = apartments;
					result = mapper.writeValueAsString(details);
				}else {
					result = "error";
				}
			}else {
				result = "login";
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

		return result;
	}

	/*
	 * public String getApartment(String id) {
	 * 
	 * String result = ""; try {
	 * 
	 * 
	 * 
	 * } catch (Exception e) { System.out.println("Error : " + e); }
	 * 
	 * return result; }
	 */
}
