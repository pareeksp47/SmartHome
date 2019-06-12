<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.exchange.isep.helper.JavaEmail"%>
<%@page import="com.exchange.isep.model.User"%>
<%@ page import="javax.mail.MessagingException"%>

<%@ page import="com.exchange.isep.controller.AdminDashboardController"%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Create New Password</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/login_styles_second.css">
    
<!--     <link href="/smarthome/css/faq.css" rel="stylesheet" id="bootstrap-css"> -->
<script src="/smarthome/js/validate.js" type="text/javascript"></script>


</style>
</head>
<body>

<%
	HttpSession reqSession = request.getSession(false);
	User user = (User) reqSession.getAttribute("user");
	
	//ArrayList<User> userList = (ArrayList) reqSession.getAttribute("userList");

	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<div class="bg-image"></div>
    <!-- <div class="header">
            <img src="Bigtree_logo.JPG" alt="Bigtree_logo" width="100" height="100"><h1> BIGTREE</h1>
        </div> -->

    <img src="images\logo.png" alt="Bigtree_logo">

    <div class="login">
        <h2>Create New Password</h2>
        <form action="forgotPasswordChange" method="POST"> 
            <div class="login-parameters">
                 <div class="input-field">
                   
					<input type="email" value="<%out.print(request.getAttribute("email"));%>" name="email" required>
                </div>
                
               
                <div class="input-field">
                    <!-- <label for="psw"><b>Password</b></label><br /> -->
                    <input type="password" placeholder="New Password" name="pswd" required>
                </div>
				    <div class="input-field">
                    <!-- <label for="psw"><b>Password</b></label><br /> -->
                    <input type="password" placeholder="Confirm New Password" name="conpswd" required>
                </div>

            </div>


			
            <button class="signInBtn" type="submit" name="frgt_btn"> <!--onclick="show_confirm()" value="Show confirm box"--> Save</button>
			
			<div style="margin-top: 20px;"> Login/Register? <button class="clickBtn" style="width:auto;" id="signupBtn"><a href="index.php">Click here</a></button>
                <!-- <button id="signupBtn" type="submit">Sign Up</button> -->
            </div>
        </form>
    </div>
	
	
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/smarthome/css/footer.css">

	<div class="footer-main-div">

<div class="footer-social-icons">
<ul>
<li><a href="https://www.facebook.com/" target="_blank"><i class="fa fa-facebook"></i></a></li>
<li><a href="https://twitter.com/Twitter?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor" target="_blank"><i class="fa fa-twitter"></i></a></li>
<li><a href="https://plus.google.com/discover" target="_blank"><i class="fa fa-google-plus"></i></a></li>
<li><a href="https://www.instagram.com/" target="_blank"><i class="fa fa-instagram"></i></a></li>
</ul>
</div>

<div class="footer-menu-one">
<ul>
<li><a href="/smarthome/site/unauthorized/home.php">Home</a></li>
<li><a href="/smarthome/site/user/contact-us.php">Contact us</a></li>
</ul>
</div>
<div class="footer-menu-two">
</div>

</div>

<div class="footer-bottom">
<p>Copyright@<a href="#">2019</a></p>

</div>

</body>


</html> 
