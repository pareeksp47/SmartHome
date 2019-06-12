let validateMyForm = function()
{
	
	let first_name = document.forms["myForm"]["first_name"].value;
	let last_name = document.myForm.last_name.value;
	let password = document.forms["myForm"]["pswd"].value;
	let confirm_password = document.forms["myForm"]["conpswd"].value;
	let letter= /^[a-zA-Z]+$/;
	let regex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
	
	if(password != "") {
		if(password != confirm_password){
			alert("The passwords do not match!")
			return false;
		}
		if(!regex.test(password)){
			alert("Password must contain atleast 8 characters containing 1 uppercase letter, 1 lowercase letter, 1 numeric character and 1 special character ");
			return false;
		}
	}
//	if(password.length<8){
//		alert("Password must contain atleast 8 characters");
//		return false;
//	}
//	let x = /A-Z/;
//	if(!x.test(password)){
//		alert("Password must contain atleast 1 uppercase letter");
//		return false;
//	}
//	let y = /a-z/;
//	if(!y.test(password)){
//		alert("Password must contain atleast 1 lowercase letter");
//		return false;
//	}
//	let z= /[0-9]/;
//	if(!z.test(password)){
//		alert("Password must contain atleast 1 numeric character");
//		return false;
//	}
//	let a= /[!@#\$%\^&]/;
//	if(!z.test(password)){
//		alert("Password must contain atleast 1 special character");
//		return false;
//	}
	if(!first_name.match(letter))
	{
		alert("Please enter only alphabets for first name");
		return false;
	}
	if(!last_name.match(letter))
	{
		alert("Please enter only alphabets for last name");
		return false;
	}
	
	
	return true;
}

let validateForm = function (){
	
	let email = document.forms["Form"]["email"].value;
	let name = document.forms["Form"]["name"].value;
//	let letter= /^[a-zA-Z]+$/;
//	if(!name.match(letter))
//	{
//		alert("Please enter only alphabets for name");
//		return false;
//	}
	let check = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!check.test(email))
	{
		alert("This email address is not valid");
		return false;
	}
	return true;
}