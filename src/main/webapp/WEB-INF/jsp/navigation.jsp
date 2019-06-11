<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.exchange.isep.model.User"%>
<!DOCTYPE html>
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
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Arbutus Slab'
rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Kaushan Script'
rel='stylesheet'>
<link rel="stylesheet" type="text/css"
href="/smarthome/css/userDashboard.css">
<link rel="stylesheet" type="text/css"
href="/smarthome/css/navigation.css">
</head>
<body>

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
		<a href="./userDashboard">Dashboard</a> <a href="#">Profile</a> <a href="#">Support</a>
		<a href="./FAQ">FAQ</a>
	</div>

</body>
</html>