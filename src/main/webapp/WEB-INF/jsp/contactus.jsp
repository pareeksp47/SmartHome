<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.exchange.isep.helper.JavaEmail"%>
<%@ page import="javax.mail.MessagingException"%>
<%
	String message = null;
	String status = null;
	if (request.getParameter("submit_button") != null) {
		JavaEmail javaEmail = new JavaEmail();
		javaEmail.setMailServerProperties();
		String emailSubject = "Contact Form using Java JSP GMail";
		String emailBody = "";
		if (request.getParameter("name") != null) {
			emailBody = "Sender Name: " + request.getParameter("name")
					+ "<br>";
		}
		if (request.getParameter("email") != null) {
			emailBody = emailBody + "Sender Email: "
					+ request.getParameter("email") + "<br>";
		}
		
		if (request.getParameter("message") != null) {
			emailBody = emailBody + "Message: " + request.getParameter("message")
					+ "<br>";
		}
		javaEmail.createEmailMessage(emailSubject, emailBody);
		try {
			javaEmail.sendEmail();
			status = "success";
			message = "Email sent Successfully!";
		} catch (MessagingException me) {
			status = "error";
			message = "Error in Sending Email!";
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
<link rel="stylesheet" type="text/css" href="/smarthome/css/userDashboard.css">
<jsp:include page="basic.jsp" />
<script src="/smarthome/js/validate.js" type="text/javascript"></script>
</head>
<body>
	<%-- <jsp:include page="header.jsp" />  --%>
	<div class="header">
        <a href="logout.php"><img class="logo" src="images\logo.png" alt="logo" width="75" height="75"><span style="color:white;padding-top: 20px;position: absolute;font-size: 24px;">DOMISEP</span>
        </a>
        <ul>
            <li><a class="home_link" href="user-dashboard1.php" class="home-click" >
                    Home</a></li>
            <li><a class="faq_link" href="faq-page.php">
                    FAQ </a></li> 
            <li><a class="support_link" href="support-page.php">
                    Support</a></li>
            <li><a class="home_link" href="profile-page.php">
                    Profile</a></li>
            <li><a class="home_link" href="logout.php">Logout</a></li>
        </ul>
    </div>
	<div class="main">
        <div id="support-content">
            <ul class="breadcrumb">
                <li><a href="#"><b>Contact Us</b></a></li>
            </ul>
            <div class="center-part">
                <div class="welcome-user-contact">
                    We are always here to serve you!
                </div>
                <div class="support-form">
                    <form id="support-form" action="contactus" method="post" onsubmit="return validateForm()" name="Form">
                        <input name="name" type="text" class="form-control" placeholder="Your Name" required><br>
                        <input name="email" type="text" class="form-control" placeholder="Your Email Address" required ><br>
                        <textarea name="message" class="form-control" placeholder="Message" rows="4" required ></textarea><br>
                        <input type="submit" class="form-control submit" value="Send Message" name="submit_button"> 
                        <!--<button type="submit" class="form-control submit" name="save_btn" class="btn">Send Message</button>-->
                    </form>
                </div>
            </div>
        </div>
    </div>
	<%--<jsp:include page="footer.jsp" />  --%>
</body>
</html>