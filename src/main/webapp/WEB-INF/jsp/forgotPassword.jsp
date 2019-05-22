<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <title>Create New Password - Bigtree</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/login_styles_second.css">
   
</head>
<body>
  <div class="logo">
<!--         <a href="show-user.php"><img src="images\logo.png" style="float: left;width: 75px;height: 75px;margin-top:-20px;"></a> -->
        <span style="float:left;color:white;padding:20px 20px;position:relative;font-family: Arial;font-size: 18px;margin-top:-10px;">ISEP SMART-HOME</span>
    </div>

    <div class="bg-image"></div>
    <!-- <div class="header">
            <img src="Bigtree_logo.JPG" alt="Bigtree_logo" width="100" height="100"><h1> BIGTREE</h1>
        </div> -->

    <img src="images\logo.png" alt="Bigtree_logo">

    <div class="login">
        <h2>Email Verification</h2>
        <form action="Forgot_Password.php" method="POST"> 
            <div class="login-parameters">
                <div class="input-field">
                    <!-- <label for="name"><b>Email</b></label><br /> -->
					<p>Enter your Email ID</p>
					<input id="email" type="text" placeholder="Email" name="email" required>
                </div>
             </div>
			<?php
				if(isset($_SESSION['message']))
				{
					display_message($_SESSION['message']);
				}
			?>
			 
            <button class="signInBtn" type="submit" name="frgt_btn">Confirm</button>
			
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
a
</body>

</html>
