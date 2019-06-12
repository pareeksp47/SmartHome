<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<jsp:include page="basic.jsp" />
<script src="/smarthome/js/registration.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="/smarthome/css/register.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>

<jsp:include page="header_reg.jsp" />
<br/>
<div class="body">
 <div class="container" >
 <!---heading---->
     <header class="heading"> User Registration </header>
	 <div class = "space"></div>
	<!---Form starting----> 
	<form method="post" name="" action="saveUserDetails">
	<div class="row ">
	 <label class="error hidden" id="error"></label>
	 <!--- For Name---->
         <div class="col-sm-12">
             <div class="row">
			     <div class="col-xs-4">
          	         <label class="firstname">First Name </label> </div>
		         <div class="col-xs-8">
		             <input type="text" name="fname" id="fname" placeholder="Enter your First Name" class="form-control ">
             </div>
		      </div>
		 </div>
		 
		 
         <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
                     <label class="lastname">Last Name </label></div>
				<div class ="col-xs-8">	 
		             <input type="text" name="lname" id="lname" placeholder="Enter your Last Name" class="form-control last">
                </div>
		     </div>
		 </div>
     <!-----For email---->
		 <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
		             <label class="mail" >Email </label></div>
			     <div class="col-xs-8"	>	 
			          <input type="email" name="email"  id="email" placeholder="Enter your email" class="form-control" >
		         </div>
		     </div>
		 </div>
	 <!-----For Password and confirm password---->
          <div class="col-sm-12">
		         <div class="row">
				     <div class="col-xs-4">
		 	              <label class="pass">Password </label></div>
				  <div class="col-xs-8">
			             <input type="password" name="password" id="password" placeholder="Enter your Password" class="form-control">
				 </div>
          </div>
		  </div>
		  <br/>
		  <br/>
		  
		  <!-----For Password and confirm password---->
		   
            <div class="col-sm-12 col-sm-exr" > 
		         <div class="row">
				     <div class="col-xs-4">
		 	              <label class="pass">Confirm Password &nbsp</label></div>
				  <div class="col-xs-8">
			             <input type="password" name="cpassword" id="cpassword" placeholder="Confirm your Password" class="form-control">
				 </div>
          </div> 
		  </div>
		  
		   <!-----Gender---->
		          <div class="col-sm-12 col-sm-exr" style="padding-top: 0px;" > 
		         <div class="row">
				     <div class="col-xs-4">
		 	              <label class="pass">Gender &nbsp</label></div>
				 <div class="col-xs-4"> 
				  <label class="pass">
			             Male  <input type="radio" name="gender" id="male" value="Male"  checked>  </label>
			             <label class="pass"> 
			             Female  <input type="radio" name="gender" id="female" value="Female" > </label>
				 </div> 
				
          </div> 
		  </div>
		  
		  <br/>
		  <br/>
    
	 
         <div class="col-sm-12" style="padding-top: 20px;">
		
		     <div class="col-sm-12">
		         <div  >
				 <input class="button"  id="submit" name="submit" type="submit" value=
                            "Submit" >
							
				 
		   </div>
		 </div>
		 
	 </div>	 
	 </div>
	</form>	 		 
	<br>	 

</div>
</div>
</body>
<script src="/smarthome/js/registration.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
</html>