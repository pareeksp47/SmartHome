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
<title>Insert title here</title>
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
<div class="header">
    <!-- start: Header Menu Team logo -->
    <div class="logo">
        <a href="show-user.php"><img src="images\logo.png" style="float: left;width: 75px;height: 75px;margin-top:-20px;"></a>
        <span style="float:left;color:white;padding:20px 20px;position:relative;font-family: Arial;font-size: 18px;margin-top:-10px;">ISEP SMART-HOME</span>
    </div>
    <!-- end: Header Menu Team logo -->
    <ul class="top-nav" style="width: 75%;float: left;display: inline-block;">
        <!-- <?php $row = mysqli_fetch_array($results) ?> -->
        <li><a href="#">User Management</a></li>
        <li><a href="#">Add Admin</a></li>
        <li><a href="#" >Edit FAQ</a></li>
        <li><a href="#">Privacy&Terms</a></li>
        <li><img src="images\boss.png" style="margin:0px 0px 0px 280px;"></li>
        <div style="margin: 2px 2px; margin-top:-15px;">
        
        <% 
    HttpSession reqSession = request.getSession(false);
    User user = (User) reqSession.getAttribute("user");
    ArrayList<User> userList = (ArrayList) reqSession.getAttribute("userList");
    %>
        
                <strong style="font-size: large;"><% out.println(user.getFirstName());%></strong>
                <small>
                    <i  style="color:#888;margin-right: 1px;"></i>&nbsp;
                    <button class="logout_btn"><a href="../../index.php?logout='1'" style="text-decoration: none;">Logout</a></button>
                 
                </small>
                
            
        </div>
        <?php ?>
    </ul>
</div>
	<div class="content">
<!-- 		<!-- notification message --> 
<!-- 			<div class="error success" > -->
<!-- 				<h3> -->
<!-- 					<?php  -->
<!-- 				</h3> -->
<!-- 			</div> -->

		<!-- logged in user information -->
        <div class="profile_info" style="margin: -20px;">
        </div>



<!--Search box for admin users-->

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search Name..."style="margin:20px 130px;margin-bottom: auto;">
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
      <th>first_name</th>
      <th>last_name</th>
      <th>Email</th>
      <th>Type</th>
<th colspan="5">Action</th> 
    </tr>
    
    
	
	 <% 
	 if(userList !=null && userList.size() > 0){
	 for(int i =0;i<userList.size();i++) { %>
	<tr> 
        <td> <% out.println(userList.get(i).getId());%></td>
        <td> <% out.println(userList.get(i).getFirstName());%></td> 
        <td> <% out.println(userList.get(i).getLastName());%></td>
        <td> <% out.println(userList.get(i).getEmail());%></td>
        <td> <% out.println(userList.get(i).getUserRole());%></td>
        <td><a href="delete.jsp?id=<%=userList.get(i).getId() %>" class="del_btn">Delete</a></td>
    </tr>
	<% } %> 
	<% } %> 




<!--start: pagination -->
	
    <tr>
   		<td colspan="10"><?php echo $row['page'];?>
		    <a href="page.php?page=1">First</a>
		    <a href="page.php?page=' . ($page - 1) . '">Previous</a>
		    <a href="page.php?page=' . ($page + 1) . '">Next</a>
		    <a href="page.php?page=' . $total . '">Last</a>
		    <!-- This is ' . $page . 'Page  there are' . $total . 'Page -->
    	</td>
    </tr>
<!--end: pagination  -->
</table>

 	</div>
    <div class="footer">
       <!-- <h5 style="text-align: center; font-family: Hei; ">User Admin - 2019 © DOMISEP all rights reserved!</h5>-->
    </div>


</body>
</html>