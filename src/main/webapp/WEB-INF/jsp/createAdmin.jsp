<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <a href="#"><img src="images\logo.png" style="float: left;width: 75px;height: 75px;margin-top:-20px"></a>
        <span style="float:left;color:white;padding:20px 20px;position:relative;font-family: Arial;font-size: 18px;margin-top: -10px;">ISEP SMART-HOME</span>
    </div>
    <!-- end: Header Menu Team logo -->
    <ul class="top-nav" style="width: 75%;float: left;display: inline-block;">
        <?php //$row = mysqli_fetch_array($results) ?>
        <li><a href="#">User Management</a></li>
        <li><a href="#">Add Admin</a></li>
        <li><a href="#">Edit FAQ</a></li>
        <li><a href="#">Privacy&Terms</a></li>
        <li><img src="images\boss.png" style="margin:0px 0px 0px 280px;"></li>
       <div style="margin: 2px 2px; margin-top:-15px;">
           

 <!--  <?php  //if (isset($_SESSION['first_name'])) : 
			
                $email=$_SESSION['email'];

                $sqlu ="SELECT * FROM users WHERE email='$email'";
                $q_run_user = mysqli_query($db,$sqlu);
                $user = mysqli_fetch_array($q_run_user);
				//$email=$_SESSION['email'];
                
			
			?>	-->
                <strong style="font-size: large;">Sivakumar<!-- <?php echo $user['first_name']; ?> --></strong>
                <small>
                    <i  style="color: #888;margin-right: 1px;"><!-- (<?php echo ucfirst($user['type']); ?>) --></i>
                    <button class="logout_btn"><a href="../../index.php?logout='1'" style="text-decoration: none;">logout</a></button>
                 
                </small>

        </div>
        <!-- <?php ?>  -->
    </ul>
</div>
	<h2 style="text-align: center;margin-top: 50px;">Add Admin</h2>
	<form method="post" action="create_admin.php">

		<?php //echo display_error(); ?>

		<div class="input-group">
			<label>First Name</label>
			<input type="text" name="first_name"  placeholder=""> 
		</div>
		<div class="input-group">
			<label>Last Name</label>
			<input type="text" name="last_name" placeholder=""> 
		</div>
		<div class="input-group">
			<label>Email</label>
			<input type="email" name="email" placeholder=""> 
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
			<input type="password" placeholder="" name="password">
		</div>
		<div class="input-group">
			<label>Confirm password</label>
			<input type="password" placeholder="" name="con_pswd">
		</div>
		<div class="input-group">
			<button type="submit" class="btn" name="submit_btn"> Create admin</button>
		</div>
	</form>
	<div class="footer">
	<!--<h5 style="text-align: center; font-family: Hei; ">User Admin - 2019 © DOMISEP all rights reserved! Powered By BIGTREE</h5>-->
</div>
</body>
</html>