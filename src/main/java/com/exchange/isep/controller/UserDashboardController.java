/**
 * 
 */
package com.exchange.isep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author MANJUSREE
 * This controller is responsible to get the dashboard of apartment-sensor information.
 */
@Controller
public class UserDashboardController {

  @Autowired
  private UserDashboardRepository userDashboardRepository;

  Logger logger = LoggerFactory.getLogger(UserDashboardController.class);

  @GetMapping({
    "/userDashboard"
  })
  public String userDB(Model model, HttpServletRequest request) {

    String result = "userDashboard";

    try {

      HttpSession reqSession = request.getSession(false);

      if (null == reqSession || null == reqSession.getAttribute("user")) {

        result = "login";
      } else {

        reqSession.setAttribute("userDetails", userDashboardData(request));
      }
    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while getting user dahboard page : " + e.getMessage());
    }

    return result;
  }

  public DashboardDetails userDashboardData(HttpServletRequest request) {

    DashboardDetails result = null;
    try {

      HttpSession session = request.getSession(false);
      if (null != session) {

        User user = (User) session.getAttribute("user");
        if (null != user) {

          List < Apartment > apartments = userDashboardRepository.apartments(user.getId());
          for (Apartment apartment: apartments) {

            List < Room > rooms = userDashboardRepository.rooms(apartment.getId());
            apartment.setRooms(rooms);
            for (Room room: rooms) {

              List < Sensor > sensors = userDashboardRepository.sensors(room.getId());
              room.setSensors(sensors);
            }
          }

          DashboardDetails details = new DashboardDetails();
          details.apartments = apartments;

          result = details;
        } else {
          result = null;
        }

      } else {
        result = null;
      }

    } catch (Exception e) {
      logger.error("Error occured while getting user dashboard data : " + e);
      result = null;
    }

    return result;
  }

  @RequestMapping(value = "saveHouse", method = RequestMethod.POST)
  public String saveApartment(@RequestParam(value = "name") String name,
    @RequestParam(value = "houseName") String houseName,
    @RequestParam(value = "street") String street,
    @RequestParam(value = "city") String city,
    @RequestParam(value = "country") String country,
    @RequestParam(value = "zipCode") String zipCode,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session) {
        result = "login";
      } else {
        User user = (User) session.getAttribute("user");
        if (null == user) {
          result = "login";
        } else {
          Apartment apt = new Apartment(0, name, user.getId(), houseName, street, city, country, zipCode);
          userDashboardRepository.addApartment(apt);
          result = "redirect:/userDashboard";
        }
      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error :" + e);
    }

    return result;
  }

  @RequestMapping(value = "saveRoom", method = RequestMethod.POST)
  public String addRoom(@RequestParam(value = "name") String name,
    @RequestParam(value = "apartmentId") int apartmentId,
    @RequestParam(value = "roomType") String roomType,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session || null == session.getAttribute("user")) {

        result = "login";
      } else {

        Room room = new Room(0, name, apartmentId, roomType);
        userDashboardRepository.addRoom(room);
        result = "redirect:/userDashboard";

      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while saving the roomm details :" + e.getMessage());
    }

    return result;
  }

  /**
   * Save new sensor
   * @param name
   * @param roomId
   * @param sensorType
   * @param request
   * @return
   */
  @RequestMapping(value = "saveSensor", method = RequestMethod.POST)
  public String addSensor(@RequestParam(value = "name") String name,
    @RequestParam(value = "roomId") String roomId,
    @RequestParam(value = "sensorType") String sensorType,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session || null == session.getAttribute("user")) {

        result = "login";
      } else {

        Sensor sensor = new Sensor(0, name, roomId, sensorType);
        userDashboardRepository.addSensor(sensor);
        result = "redirect:/userDashboard";
      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while saving the sensor details : " + e.getMessage());
    }

    return result;
  }

  /**
   * Update sensor status
   * @param id
   * @param status
   * @param request
   * @return
   */
  @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
  @ResponseBody
  public String updateSensor(@RequestParam(value = "id") int id,
    @RequestParam(value = "status") String status,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session || null == session.getAttribute("user")) {

        result = "login";
      } else {

        userDashboardRepository.updateSensor(id, status);
        result = "success";
      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while updating the sensor status :" + e.getMessage());
    }

    return result;
  }

  /**
   * Delete existing Home 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping(value = "deleteHome", method = RequestMethod.GET)
  public String delteApartment(@RequestParam(value = "id") int id,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session || null == session.getAttribute("user")) {
        result = "login";
      } else {
        userDashboardRepository.deleteApartment(id);
        result = "redirect:/userDashboard";
      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while deleting home:" + e.getMessage());
    }

    return result;
  }

  /**
   * Delete existing Room 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping(value = "deleteRoom", method = RequestMethod.GET)
  public String deleteRoom(@RequestParam(value = "id") int id,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session || null == session.getAttribute("user")) {

        result = "login";
      } else {

        userDashboardRepository.deleteRoom(id);
        result = "redirect:/userDashboard";
      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while deleting room :" + e.getMessage());
    }

    return result;
  }

  /**
   * Delete existing sensor
   * @param id
   * @param request
   * @return
   */
  @RequestMapping(value = "deleteSensor", method = RequestMethod.GET)
  public String deleteSensor(@RequestParam(value = "id") int id,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session || null == session.getAttribute("user")) {

        result = "login";
      } else {

        userDashboardRepository.deleteSensor(id);
        result = "redirect:/userDashboard";
      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while deleting the sensor :" + e.getMessage());
    }

    return result;
  }

}