<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.exchange.isep.model.UserDao"%>
<%@page import="com.exchange.isep.model.ApartmentDao"%>
<%@page import="com.exchange.isep.model.Apartment"%>
<%@page import="com.exchange.isep.model.User"%>

<%
	/* TODO: add line to get user id from session variable or somewhere else, 
	if not set redirect to login page, pass user id in get functions*/
	Apartment apartment = ApartmentDao.getAppartmentByUserId(1);
	User user = UserDao.getUserById(1);
	request.setAttribute("apartment", apartment);
	request.setAttribute("user", user);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" type="text/css"
	href="/smarthome/css/userDashboard.css">
<jsp:include page="basic.jsp" />
<script src="/smarthome/js/validate.js" type="text/javascript"></script>
</head>
<body>
	<%--<jsp:include page="header.jsp" />  --%>
	<div class="header">
		<a href="logout.php"><img class="logo" src="images\logo.png"
			alt="logo" width="75" height="75"><span
			style="color: white; padding-top: 20px; position: absolute; font-size: 24px;">DOMISEP</span>
		</a>
		<ul>
			<li><a class="home_link" href="user-dashboard1.php"
				class="home-click"> Home</a></li>
			<li><a class="faq_link" href="faq-page.php"> FAQ </a></li>
			<li><a class="support_link" href="support-page.php"> Support</a></li>
			<li><a class="home_link" href="profile-page.php"> Profile</a></li>
			<li><a class="home_link" href="logout.php">Logout</a></li>
		</ul>
	</div>
	<div class="main">
		<div id="profile-content" class="span10">
			<ul class="breadcrumb">
				<li><a href="#"><b>My Profile</b></a></li>
			</ul>

			<div class="center-part">
				<c:out value="${sessionScope.message}" />
				<%
					request.getSession().removeAttribute("message");
				%>
				<form id="change-pswd-form" method="post" action="updateProfile"
					onsubmit="return validateMyForm()" name="myForm">
					<input type="hidden" name="id" value="<%=user.getId()%>" /> <input
						type="hidden" name="apptId" value="<%=apartment.getId()%>" />
					<div
						style="font-size: 22px; margin-bottom: 15px; margin-top: 5px; font-weight: 600;">
						<u>Change Password:</u>
					</div>
					<div class="input-group">
						<label>Email</label> <input type="text" name="email"
							value="${user.getEmail()}">
					</div>
					<div class="input-group">
						<label>New password</label> <input type="password" name="password"
							value="${user.getPassword()}">
					</div>
					<div class="input-group">
						<label>Confirm password</label> <input type="password"
							name="password" value="${user.getPassword()}">
					</div>
					<div class="submitbutton">

						<div
							style="font-size: 22px; margin-bottom: 15px; margin-top: 5px; font-weight: 600;">
							<u>Personal Information:</u>
						</div>
						<div class="input-group">
							<label>First Name</label> <input type="text" name="firstName"
								value="${user.getFirstName()}">
						</div>
						<div class="input-group">
							<label>Last Name</label> <input type="text" name="lastName"
								value="${user.getLastName()}">
						</div>

						<div class="input-group">
							<label>Address</label> <input type="text" name="street"
								value="${apartment.getStreet()}"> <label>City</label> <input
								type="text" name="city" value="${apartment.getCity()}">
							<label>Zip Code</label> <input type="text" name="zipCode"
								value="${apartment.getZipCode()}">
							<!--<textarea name="address" class="form-control" placeholder="Address" rows="3" required>-->

							<!--</textarea>  -->
						</div>

						<p>Make sure all the information is right!</p>
						<div class="submitbutton">
							<button type="submit" name="save_btn" class="btn">Save</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>


	<!--<jsp:include page="footer.jsp" />  -->
</body>
</html>