<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <%@ page import="java.util.ArrayList"  %>
    <%@ page import="com.exchange.isep.controller.AdminDashboardController"  %>
    <%@ page import="com.exchange.isep.model.User"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css" href="/smarthome/css/style.css">
<link href="/smarthome/css/register.css" rel="stylesheet" id="bootstrap-css">
<script type="text/javascript" src="/smarthome/js/registration.js"></script>
<script>
function myFunction() {
	   var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	 
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) { 
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}
	
</script>
</head>
<body>
<div class="header">
    <!-- start: Header Menu Team logo -->
    <div class="logo">
        <a href="#"><img src="images\logo.png" style="float: left;width: 75px;height: 75px;margin-top:-20px"></a>
        <span style="float:left;color:white;padding:20px 20px;position:relative;font-family: Arial;font-size: 18px;margin-top: -10px;">ISEP SMART-HOME</span>
    </div>
    <!-- end: Header Menu Team logo -->
    <ul class="top-nav" style="width: 75%;float: left;display: inline-block;">
       <!--  <?php //$row = mysqli_fetch_array($results) ?> -->
        <li><a href="#">User Management</a></li>
        <li><a href="#">Add Admin</a></li>
        <li><a href="#">Edit FAQ</a></li>
        <li><a href="#">Privacy&Terms</a></li>
        <li><img src="images\boss.png" style="margin:0px 0px 0px 280px;"></li>
       <div style="margin:2px 2px; margin-top:-15px;">
           

 			   
        <% 
    HttpSession reqSession = request.getSession(false);
    User user = (User) reqSession.getAttribute("user");
    ArrayList<User> userList = (ArrayList) reqSession.getAttribute("userList");
    
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	 response.setHeader("Pragma", "no-cache");
	 response.setDateHeader("Expires", 0);
    %>
                <strong style="font-size: large;"><% out.println(user.getFirstName());%></strong>
                <small>
                    <i  style="color: #888;margin-right: 1px;"></i>
                    <button class="logout_btn"><a href="../../index.php?logout='1'" style="text-decoration: none;">logout</a></button>
                 
                </small>

        </div>
    </ul>
</div>
	<h2 style="text-align: center;margin-top: 50px;">Add Admin</h2>
	<form method="post" action="saveAdminDetails">
		<label class="error hidden" id="error"></label>

		<div class="input-group">
			 <label>First Name </label>
			<input type="text" name="fname" id="fname" placeholder="" class="form-control "> 
		</div>
		<div class="input-group">
			<label>Last Name</label>
			<input type="text" name="lname" id="lname" placeholder=""> 
		</div>
		<div class="input-group">
			<label>Email</label>
			<input type="email" name="email" id="email" placeholder=""> 
		</div>
		<!--<div class="input-group">
			<label>User type</label>
			<select name="user_type" id="user_type" >
				<!-- <option value=""></option> 
				<option value="admin">Admin</option>
				<!-- <option value="user">User</option> 
			</select>
		</div>-->
		<div class="input-group">
			<label>Password</label>
			<input type="password" placeholder=""  id="password" name="password">
		</div>
		<div class="input-group">
			<label>Confirm password</label>
			<input type="password" placeholder="" id="cpassword" name="cpassword">
		</div>
		<div class="input-group">
			<input type="submit" class="button" name="submit" id="submit_admin" value=
                            "Create Admin" > 
		</div>
	</form>
	<div class="footer">
	<!--<h5 style="text-align: center; font-family: Hei; ">User Admin - 2019 © DOMISEP all rights reserved! Powered By BIGTREE</h5>-->
</div>
</body>
<script src="/smarthome/js/registration.js"></script>
</html>