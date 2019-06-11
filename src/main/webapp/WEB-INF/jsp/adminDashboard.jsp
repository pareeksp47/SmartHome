<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.exchange.isep.controller.AdminDashboardController"%>
<%@ page import="com.exchange.isep.model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	HttpSession reqSession = request.getSession(false);
	User user = (User) reqSession.getAttribute("user");
	ArrayList<User> userList = (ArrayList) reqSession.getAttribute("userList");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Arbutus Slab'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Kaushan Script'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="/smarthome/css/style.css">
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

	<div class="menu loggedout">
		<div class="leftmenu">
			<!--<img class="icon" src="/smarthome/images/icon.png" />-->
			<a href="/smarthome/" class="homeicon"> <img class="icon"
				src="/smarthome/images/logo.png" />&nbsp;&nbsp;<label
				class="domisep">Smart Home </label>
			</a>
		</div>

		<div class="rightmenu">
			<img src="images\avatar_image.png" alt="Avatar" class="avatar">
			<div class="userName">
				<%
					out.print(user.getFirstName());
				%>
			</div>
			<a class="logout" href="#">Logout</a>
		</div>
	</div>
	<!-- 	<div class="side-nav-admin-taskbar"> -->
	<!-- 		<div class="leftmenu"> -->
	<!-- 			<a href="/smarthome/userDashboard" class="homeicon"> <img -->
	<!-- 				class="icon" src="/smarthome/images/logo.png" /> <label -->
	<!-- 				class="domisep">Smart Home </label> -->
	<!-- 			</a> -->

	<!-- 		</div> -->
	<!-- 		<div class="profile_part"> -->
	<!-- 			<img src="images\avatar_image.png" alt="Avatar" class="avatar"> -->
	<!-- 			<h2 -->
	<!-- 				style="color: #10A976; text-align: center; font-size: 16px; font-family: 'Arbutus Slab';"> -->
	<%-- 				<% --%>
	<!-- // 					out.print(user.getFirstName()); -->
	<%-- 				%> --%>
	<!-- 			</h2> -->
	<!-- 		</div> -->
	<!-- 		<a href="#">Dashboard</a> <a href="#">Profile</a> <a href="#">Support</a> -->
	<!-- 		<a href="#">FAQ</a> -->
	<!-- 	</div> -->
	<div class="content">
		<!-- 		<!-- notification message -->
		<!-- 			<div class="error success" > -->
		<!-- 				<h3> -->
		<!-- 					<?php  -->
		<!-- 				</h3> -->
		<!-- 			</div> -->

		<!-- logged in user information -->
		<!-- 		<div class="profile_info" style="margin: -20px;"></div> -->



		<!--Search box for admin users-->
		<div style="display: flex; flex-wrap: wrap; margin-right: 0px;">
		<input type="text" id="myInput" onkeyup="myFunction()"
			placeholder="Search Name..." style="">
		<div class="addAdminButton">
			<a href="javascript:void(0)"
				onclick="document.getElementById('addHomeModal').style.display='block'">
				<span> <img class="add-home" src="https://img.icons8.com/metro/52/000000/add-user-male.png"
					alt="Add home button"
					style="width: 40px; height: 40px; margin-right: 5px; margin-bottom: -10px;">
			</span> 					 <span> Create Admin </span>
			</a>
		</div>
		</div>
		<!-- when user manipulate database show messages here -->

		<!--start: pagination script -->
		<%-- <%@page import="java.sql.DriverManager"%> --%>
		<%-- 			<%@page import="java.sql.ResultSet"%> --%>
		<%-- 			<%@page import="java.sql.Statement"%> --%>
		<%-- 			<%@page import="java.sql.Connection"%> --%>

		<%-- 			<% --%>


		<%-- 			%> --%>

		<!--end: pagination script -->

		<table id="myTable">
			<tr class="header">
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Type</th>
				<th colspan="5"></th>
			</tr>

			<%
				if (userList != null && userList.size() > 0) {
					for (int i = 0; i < userList.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.println(userList.get(i).getId());
					%>
				</td>
				<td>
					<%
						out.println(userList.get(i).getFirstName());
					%>
				</td>
				<td>
					<%
						out.println(userList.get(i).getLastName());
					%>
				</td>
				<td>
					<%
						out.println(userList.get(i).getEmail());
					%>
				</td>
				<td>
					<%
						out.println(userList.get(i).getUserRole());
					%>
				</td>
				<td style="text-align: center;"><img class="del-user" src="images\del_user_icon.png">
<%-- 				<a href="delete.jsp?id=<%=userList.get(i).getId()%>" --%>
<!-- 					class="del_btn">Delete</a> -->
					</td>
			</tr>
			<%
				}
			%>
			<%
				}
			%>




			<!--start: pagination -->

			<tr>
				<td colspan="10">
					<?php echo $row['page'];?> <a href="page.php?page=1">First</a> <a
					href="page.php?page=' . ($page - 1) . '">Previous</a> <a
					href="page.php?page=' . ($page + 1) . '">Next</a> <a
					href="page.php?page=' . $total . '">Last</a> <!-- This is ' . $page . 'Page  there are' . $total . 'Page -->
				</td>
			</tr>
			<!--end: pagination  -->
		</table>

	</div>
	<!-- 	<div class="footer"> -->
	<!-- 		<!-- <h5 style="text-align: center; font-family: Hei; ">User Admin - 2019 © DOMISEP all rights reserved!</h5>-->
	<!-- 	</div> -->


</body>
</html>