<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="java.lang.Integer"%>
    <%@ page import="java.lang.Math"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FAQ</title>
<link href="/smarthome/css/faq.css" rel="stylesheet" id="bootstrap-css">
<jsp:include page="navigation.jsp" />
</head>

<body >
<div class="main">
<%! int data=2; %> 
<c:if test="${not empty lists}">

<div class="FAQHeading" >Frequently Asked Questions</div>
<br>
<div align="left" style="margin-right: 240px;">
		<ul>
		
			<c:forEach var="listValue" items="${lists}">
			<% if(data % 2 == 0){ %>
			<h3>
				<p style="font-style: normal;color: #004d4d; font-size: 23px;">${listValue.faq}</p>
			</h3>	
				<% } else { %>
				<h3><p style="font-style: italic;color:#258e8e;font-size: 20px;">&nbsp  ${listValue.faq}</p></h3>
			
				<%} %>
				<%data ++; %>
			</c:forEach>
		</ul>
</div>
	</c:if>
</div>
</body>
</html>