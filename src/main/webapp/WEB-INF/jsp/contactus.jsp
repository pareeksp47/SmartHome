<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.exchange.isep.helper.JavaEmail"%>
<%@page import="com.exchange.isep.model.User"%>
<%@ page import="javax.mail.MessagingException"%>
<%
	HttpSession reqSession = request.getSession(false);
	User user = null;
	if (null == reqSession || null == reqSession.getAttribute("user")) {

		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);

	} else {
		user = (User) reqSession.getAttribute("user");
	}

	String message = null;
	String status = null;
	if (request.getParameter("submit_button") != null) {
		JavaEmail javaEmail = new JavaEmail();
		javaEmail.setMailServerProperties();
		String emailSubject = "Contact Form using Java JSP GMail";
		String emailBody = "";
		if (request.getParameter("name") != null) {
			emailBody = "Sender Name: " + request.getParameter("name") + "<br>";
		}
		if (request.getParameter("email") != null) {
			emailBody = emailBody + "Sender Email: " + request.getParameter("email") + "<br>";
		}

		if (request.getParameter("message") != null) {
			emailBody = emailBody + "Message: " + request.getParameter("message") + "<br>";
		}
		javaEmail.createEmailMessage(emailSubject, emailBody);
		try {
			javaEmail.sendEmail();
			request.getSession().setAttribute("message", "Email sent sucessfully.");
		} catch (MessagingException me) {
			request.getSession().setAttribute("message", "Email could not be sent.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<link rel="stylesheet" type="text/css"
	href="/smarthome/css/userDashboard.css">
<link href="/smarthome/css/faq.css" rel="stylesheet" id="bootstrap-css">
<script src="/smarthome/js/validate.js" type="text/javascript"></script>
<jsp:include page="navigation.jsp" />
</head>
<body>
	<div class="main">
	<h1>Contact Us</h1>
		<c:out value="${sessionScope.message}" />
		<%
			request.getSession().removeAttribute("message");
		%>
		<div class="support-form">
			<form id="support-form" action="contactus" method="post"
				onsubmit="return validateForm()" name="Form">
				<input name="name" type="text" class="form-control"
					placeholder="Your Name" required
					value="${user.getFirstName()} ${user.getLastName()}" disabled /> <br>
				<input name="email" type="text" class="form-control"
					placeholder="Your Email Address" required
					value="${user.getEmail()}" disabled /> <br>
				<textarea name="message" class="form-control" placeholder="Message"
					rows="4" required></textarea>
				<br> <input type="submit" class="form-control submit"
					value="Send Message" name="submit_button">
				<!--<button type="submit" class="form-control submit" name="save_btn" class="btn">Send Message</button>-->
			</form>
		</div>
	</div>

</body>
</html>