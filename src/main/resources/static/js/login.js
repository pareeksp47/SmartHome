$('#login').click(function() {

	var email = $('#email').val();
	var password = $('#password').val();
	var password_regex = /^[a-zA-Z0-9\[\]\.\-#'@`~!$%^&*;:",<>?\/]{8,16}$/;

		/* validating the value of email
			1. empty check for email
			2. @ check
			3. . check
			4. string present between start point of email and @
			5. string present between . and end of email
			6. string present between @ and .
		*/
		if(typeof undefined == typeof email || null == email || "" == email ||
		   (email.indexOf('@') == -1 || email.indexOf('.') == -1 || (email.substring(0,email.indexOf('@'))).length < 1 || (email.substring(email.lastIndexOf('.'),email.length)).length <= 1 || (email.substring(email.indexOf('@'),email.lastIndexOf('.')).length < 1 ))){
			$("#error").text("UserName Invalid");
			$("#error").removeClass('hidden');
			$("#error").addClass('show');
		}else if(typeof undefined == typeof password || null == password || "" == password || !password_regex.test(password)){
			$("#error").text("Password Invalid");
			$("#error").removeClass('hidden');
			$("#error").addClass('show');
		}else{

				$("#error").text("");
				$("#error").addClass('hidden');
				$("#error").removeClass('show');
			 $.ajax({
			  type: "POST",
			  url: "authenticate",
			  data: { username: $('#email').val(), password: $('#password').val()  }
			}).done( function( msg ) {
			  //alert( "Data Saved: " + msg );
			  var page = msg;
			  console.log(msg);
			  if(msg.indexOf('error') == -1){
					document.location.href = msg;
			  }else if(msg.indexOf('System error occurred') != -1){
					$("#error").text('System error occurred. Please try again later!!');
				  $("#error").removeClass('hidden');
				  $("#error").addClass('show');
			  }
			  else{
				  
				  $("#error").text("User Name Or Password Invalid!");
				  $("#error").removeClass('hidden');
				  $("#error").addClass('show');
			  }
			 
			 
			  console.log(msg);
			});    
		}
  });

$('#reset-btn').click(function(){
	
	$('#email').val("");
	$('#password').val("");
	
	
});