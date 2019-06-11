<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="false"%>
<%@ page import="com.exchange.isep.controller.*"%>

<%@ page import="com.exchange.isep.model.User"%>
<%@ page import="com.exchange.isep.model.DashboardDetails"%>
<%@ page import="com.exchange.isep.model.Apartment"%>
<%@ page import="com.exchange.isep.model.Room"%>
<%@ page import="com.exchange.isep.model.Sensor"%>
<%@ page import="com.exchange.isep.repository.UserDashboardRepository"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    	HttpSession reqSession = request.getSession(false);
		User user  = null;
		
    	if(null == reqSession || null == reqSession.getAttribute("user")){
    		
    		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
			
    	}else{
    		user = (User) reqSession.getAttribute("user");
    	}
    
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>UserDashboard</title>
<link href='https://fonts.googleapis.com/css?family=Arbutus Slab'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Kaushan Script'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css"
	href="/smarthome/css/userDashboard.css">
<jsp:include page="basic.jsp" />
</head>
<body>
	<%-- <jsp:include page="header.jsp" /> --%>

	<div class="side-nav-taskbar">
		<div class="leftmenu">
			<a href="/smarthome/userDashboard" class="homeicon"> <img class="icon"
				src="/smarthome/images/logo.png" /> <label class="domisep">Smart
					Home </label>
			</a>

		</div>
		<div class="profile_part">
			<img src="images\avatar_image.png" alt="Avatar" class="avatar">
			<h2
				style="color: #10A976; text-align: center; font-size: 16px; font-family: 'Arbutus Slab';"><% out.print(user.getFirstName()); %></h2>
		</div>
		<a href="#">Dashboard</a> <a href="#">Profile</a> <a href="#">Support</a>
		<a href="#">FAQ</a>
	</div>
	<div class="main">
		<!-- Home content code  -->
		<div id="home-content" class="span10">
			<!-- <ul class="breadcrumb">
				<li><a href="index.html" style="color: darkcyan;">Home Page</a><i
					class="icon-angle-right"></i></li>
			</ul> -->
			<div class="center-part">
			
				<h1 class="welcome-user">Hi <% out.print(user.getFirstName()); %>, Welcome to your smart home!</h1>
				<div class="addHomeButton">
					<a href="javascript:void(0)"
						onclick="document.getElementById('addHomeModal').style.display='block'">
						<span> <img class="add-home" src="images\add-home.png"
							alt="Add home button"
							style="width: 40px; height: 40px; margin-right: 5px; margin-bottom: -15px;">
					</span>
<!-- 					 <span> Add new home </span> -->
					</a>
				</div>
<%

		DashboardDetails details = (DashboardDetails)reqSession.getAttribute("userDetails");
		
		for(Apartment apt : details.apartments){
%>

				<div id="home-block" class="addHomeBlock custom_block"
					style="display: block;">
					<div class="thumbnail">
					
						<div class="addHomeHeading"><%=apt.getName() %>
						<img src="images/del_home_icon.png" style="width: 50px;float: right;padding-bottom: 5px;height: 50px;margin-top: -10px;"></div>
					
						<div style="display: flex; flex-wrap: wrap;">
							<% for(Room room : apt.getRooms()){ %>
							<div class="add-home-temp">
								<div class="add-home-bck"
									style="background: whitesmoke; border: 1px solid; display: flex; width: 130px;">
									<a href="javascript:void(0)"> 
									<span> 
									<img
											class="add-room" src="images/<%= room.getRoomType() %>.png"
											alt="Add home button">
									</span><%= room.getName() %>
									</a>
								</div>
							
								<div id="mySidenav" class="sidenav">
								<% for(Sensor sensor : room.getSensors()){ %>
									<div class="sensor-display">
										<img src="images/<%= sensor.getSensorType() %>.png" alt="Add home button"
											style="margin: 5px; margin-top: 15px;" width="50" height="50">
										<span
											style="text-overflow: ellipsis; width: 100px; overflow: hidden; white-space: nowrap;"><%= sensor.getName() %></span>
										<div>
											<label class="switch"> <input type="checkbox" id="s<%= sensor.getId()%>" <%= (Integer.parseInt(sensor.getStatus()) == 1) ? "checked" : "unchecked" %>
												onChange="getSensorStatus(<%= sensor.getId() %>,'s<%= sensor.getId()%>')"> <span
												class="slider round"></span>
											</label>
										</div>
									</div>
									<%} %>
									<div class="sensor-display"
										onclick="document.getElementById('addSensorModal').style.display='block',  getroomid(<%=room.getId()%>);">
										<img src="images/add-sensor-alt.png" alt="Add home button"
											style="margin: 15px;" width="50" height="50"> 
											<span>
											Add Sensor</span>
									</div>
								</div>
							</div>
							<%} %>
							<div class="add-home-temp">
								<div
									style="width: 250px; height: 200px; background: white; display: inline-flex;">
								<a href="javascript:void(0)" onclick="document.getElementById('addRoomModal').style.display='block', gethomeid(<%=apt.getId()%>)">
										<span> <img class="add-room"
											src="images/add-room-block.png" alt="Add home button">
									</span> Add new room
									</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
				<%
}
%>
<%
	if(details.apartments.size() == 0){
%>
	<div>No apartment added to your profile !!</div>
<%		
	}
%>
			</div>
		</div>

		<!-- Add Home modal  -->
		<div id="addHomeModal" class="add-home-modal">
			<form class="add-modal-content animate" action="saveHouse" method="POST">
				<div>
					<span style="text-align: center;" class="modal-title input-field">
						Add new home </span> <span class="close"
						onclick="document.getElementById('addHomeModal').style.display='none'">&times;</span>
				</div>
				<div class="container">
					 <label class="error hidden" id="homeerror"></label>
					<div style="display: inline-flex;">
						<span class="add-room-img"> <img class="add-room"
							id="add-room-image" src="images/add-home-block.jpg"
							alt="Add home button">
						</span> <span class="add-room-details">
							<div class="input-field">
								<input type="text" placeholder="Home Name" name="name" id="homename"
									required>
							</div>	
							<div class="input-field">
								<input type="text" placeholder="Home Number" name="houseName" id="name"
									required>
							</div>
							<!-- <div class="input-field">
								<input type="text" placeholder="Home Address" name="address"
									required>
							</div> -->
							
							<div class="input-field">
								<input type="text" placeholder="Street" name="street" id="street"
									required>
							</div>
							
							<div class="input-field">
								<input type="text" placeholder="City" name="city" id="city"
									required>
							</div>
							
							<div class="input-field">
								<input type="text" placeholder="Country" name="country" id="country"
									required>
							</div>
							
							<div class="input-field">
								<input type="text" placeholder="Zipcode" name="zipCode" id="zipcode"
									required>
							</div>
						</span>
					</div>
					<button class="add-btn" name="add-home-btn" type="submit"
						onclick="addhome();">Add
						home now</button>
				</div>
			</form>
		</div>

		<!-- Add Room modal  -->
		<div id="addRoomModal" class="add-home-modal">
			<form class="add-modal-content animate" action="saveRoom" method="POST">
				<div>
					<span style="text-align: center;" class="modal-title input-field">
						Add new room </span> <span class="close"
						onclick="document.getElementById('addRoomModal').style.display='none'">&times;</span>
				</div>
				<div class="container">
					<div style="display: inline-flex;">
						<span class="add-room-img"> <img class="add-room"
							id="add-room-image" src="images/add-room.png"
							alt="Add home button">
						</span> <span class="add-room-details">
							<div class="input-field">
								<input type="text" placeholder="Room Name" name="name"
									required>
							</div>
							<div class="input-field">
								<select name="roomType" id="" style=""
									onchange="change_valeur();">
									<option value="">Select Room type</option>
									<option value="living-room">Living</option>
									<option value="store-room">Store room</option>
									<option value="dining">Dining</option>
									<option value="bed-room">Bed room</option>
									<option value="bath-room">Bathroom</option>
									<option value="other-room">Others</option>

								</select>
							</div>
							<div style="display: none">
								<input type="hidden" placeholder="Room type" id="apartmentId"
									name="apartmentId" required>
							</div>
						</span>
					</div>
					<button class="add-btn" name="add-room-btn" type="submit"
						onclick="">Add
						Room now</button>
				</div>
			</form>
		</div>

		<!-- Add sensor modal  -->
		<div id="addSensorModal" class="add-sensor-modal">
			<form class="add-modal-content animate" action="saveSensor" method="POST">
				<div>
					<span style="text-align: center;" class="modal-title input-field">
						Add new sensor </span> <span class="close"
						onclick="document.getElementById('addSensorModal').style.display='none'">&times;</span>
				</div>
				<div class="container">
					<div style="display: inline-flex;">
						<span class="add-sensor-img"> <img class="add-room"
							src="images/add-sen.png" alt="Add home button">
						</span> <span class="add-sensor-details">
							<div class="input-field">
								<input type="text" placeholder="Sensor Name" name="name" id="name"
									required>
							</div>
							<div class="input-field">
								<select name="sensorType">
									<option value="">Select Sensor type</option>
									<option value="light">Light</option>
									<option value="temperature">Temperature</option>
								</select>
								<!-- <input type="text" placeholder="Room type" name="room-type" required> -->
							</div>
							<div style="margin-left: 55%;">
								<label class="switch"> <input type="checkbox"
									name="status" disabled> <span
									class="slider round"></span>
								</label>
							</div>
							<div style="display: none">
								<input type="text" placeholder="Sensor type" id="roomId"
									name="roomId" required>
							</div>
						</span>
					</div>
					<button class="add-btn" type="submit" name="add-sensor-btn"
						onclick="">Add
						Sensor now</button>
				</div>
			</form>
		</div>


	</div>
	<%-- <jsp:include page="footer.jsp" /> --%>
</body>
<script src="/smarthome/js/userDashboard.js">

</script>
</html>