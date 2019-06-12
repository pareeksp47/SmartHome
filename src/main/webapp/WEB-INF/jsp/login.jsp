<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<jsp:include page="basic.jsp" />
<link href="/smarthome/css/login.css" rel="stylesheet" id="bootstrap-css">
<link href="/smarthome/css/menu.css" rel="stylesheet" id="bootstrap-css">
</head>

<body>

<jsp:include page="header.jsp" />
   <br/>
	<div class="container">
 <!---heading---->
     <header class="heading"> Login </header><hr></hr>

	<div class="row ">
	
	 <div class="col-sm-12">
             <div class="row">
			     <div class="col-xs-12">
          	         <label class="error hidden" id="error"></label> </div>
		      </div>
		 </div>
	<br/>
	<br/>
	 <!--- For Email---->
         <div class="col-sm-12">
             <div class="row">
			     <div class="col-xs-4">
          	         <label class="email">Email</label> </div>
		         <div class="col-xs-8">
		             <input type="text" name="email" id="email" placeholder="Enter your Email" class="form-control ">
             </div>
		      </div>
		 </div>
		 
		 
         <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
                     <label class="password">Password</label></div>
				<div class ="col-xs-8">	 
		             <input type="password" name="password" id="password" placeholder="Enter your Password" class="form-control last">
                </div>
		     </div>
		 </div>
     
		  <br/>
		 
		 
		  
		  <div class="col-sm-12">
		  
					<a id="forgotPassword" class="forgot-password" href="/smarthome/forgotPassword">Forgot password?</a>
		  </div>
     
		     <div class="col-sm-12">
				<div class="row">
					 <div class="button col-xs-6 loginbtn">
						<button class="button"  id="login">&nbsp;Login&nbsp;</button>
						<!-- <button id="reset" id="buttonone" class="reset-btn1">&nbsp;Reset&nbsp;</button> -->
						<button id="reset-btn" class="button">&nbsp;Reset&nbsp;</button>
					 </div>
				 </div>
				 
		   </div>
		 </div>
	 </div>	 
		 	<!-- </form> -->
		 


<script src="/smarthome/js/login.js">

</script>
	
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>