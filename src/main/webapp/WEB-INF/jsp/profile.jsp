<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.exchange.isep.model.UserDao"%>
<%@page import="com.exchange.isep.model.ApartmentDao"%>
<%@page import="com.exchange.isep.model.Apartment"%>
<%@page import="com.exchange.isep.model.User"%>

<%
	HttpSession reqSession = request.getSession(false);
	User userFromSession = null;
	User userForProfile = null;
	Apartment apartment = null;
	if (null == reqSession || null == reqSession.getAttribute("user")) {

		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);

	} else {
		userFromSession = (User) reqSession.getAttribute("user");
		apartment = ApartmentDao.getAppartmentByUserId(userFromSession.getId());
		userForProfile = UserDao.getUserById(userFromSession.getId());
		request.setAttribute("apartment", apartment);
		request.setAttribute("userForProfile", userForProfile);
	}
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" type="text/css"
	href="/smarthome/css/userDashboard.css">
<link href="/smarthome/css/faq.css" rel="stylesheet" id="bootstrap-css">

<jsp:include page="basic.jsp" />
<script src="/smarthome/js/validate.js" type="text/javascript"></script>
<jsp:include page="navigation.jsp" />
</head>
<body>
	<div class="main">
		<h1>My Profile</h1>
		<c:out value="${sessionScope.message}" />
		<%
			request.getSession().removeAttribute("message");
		%>
		<form id="change-pswd-form" method="post" action="updateProfile"
			onsubmit="return validateMyForm()" name="myForm">
			<input type="hidden" name="id" value="<%=userForProfile.getId()%>" /> <input
				type="hidden" name="apptId" value="<%=apartment.getId()%>" />
			<div
				style="font-size: 22px; margin-bottom: 15px; margin-top: 5px; font-weight: 600;">
				<u>Change Password:</u>
			</div>
			<div class="input-group">
				<label>Email</label> <input type="text" name="email"
					value="${userForProfile.getEmail()}">
			</div>
			<div class="input-group">
				<label>New password</label> <input type="password" name="password"
					value="${userForProfile.getPassword()}">
			</div>
			<div class="input-group">
				<label>Confirm password</label> <input type="password"
					name="password" value="${userForProfile.getPassword()}">
			</div>
			<div class="submitbutton">

				<div
					style="font-size: 22px; margin-bottom: 15px; margin-top: 5px; font-weight: 600;">
					<u>Personal Information:</u>
				</div>
				<div class="input-group">
					<label>First Name</label> <input type="text" name="firstName"
						value="${userForProfile.getFirstName()}">
				</div>
				<div class="input-group">
					<label>Last Name</label> <input type="text" name="lastName"
						value="${userForProfile.getLastName()}">
				</div>

				<div class="input-group">
					<label>Address</label> <input type="text" name="street"
						value="${apartment.getStreet()}"> <label>City</label> <input
						type="text" name="city" value="${apartment.getCity()}"> <label>Zip
						Code</label> <input type="text" name="zipCode"
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
</body>
</html>