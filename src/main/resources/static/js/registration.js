
$('#submit').click(function(event) {
	var flag = validateFields();
	if (!flag) {
		event.preventDefault(event);
	}else{
		
		$('#form1').submit();
	}

});

//$('#submit-admin').click(function(event) {
//	var flag = validateFields();
//	if (!flag) {
//		event.preventDefault(event);
//	}
//
//});

function validateFields(event) {
	if (!$('#fname').val()) {
		setErrorMessage("Please enter first name");
		return false;
	}

	if ($('#fname').val() && !$('#lname').val()) {
		setErrorMessage("Please enter the last name");
		return false;
	}

	if ($('#fname').val() && $('#lname').val() && !$('#email').val()) {
		setErrorMessage("Please enter the email");
		return false;
	}

	if ($('#fname').val() && $('#lname').val() && $('#email').val()
			&&  !$('#password').val()) {
		setErrorMessage("Please enter the password");
		return false;
	}

	if ($('#fname').val() && $('#lname').val() && $('#email').val()
			&& $('#email').val() && $('#password').val()
			&& !$('#cpassword').val()) {
		setErrorMessage("Please confirm the password");
		return false;
	}

	var email = $('#email').val();
	var password = $('#password').val();
	var password_regex = /^[a-zA-Z0-9\[\]\.\-#'@`~!$%^&*;:",<>?\/]{8,16}$/;
	if (typeof undefined == typeof email
			|| null == email
			|| "" == email
			|| (email.indexOf('@') == -1
					|| email.indexOf('.') == -1
					|| (email.substring(0, email.indexOf('@'))).length < 1
					|| (email.substring(email.lastIndexOf('.'), email.length)).length <= 1 || (email
					.substring(email.indexOf('@'), email.lastIndexOf('.')).length < 1))) {
		$("#error").text("Please enter a valid email id");
		$("#error").removeClass('hidden');
		$("#error").addClass('show');
		return false;
	}
	if (typeof undefined == typeof password || null == password
			|| "" == password || !password_regex.test(password)) {
		$("#error")
				.text(
						"Please enter a password that has characters between 8 and 16 and contains atleast one upper case letter,one digit and one special character");
		$("#error").removeClass('hidden');
		$("#error").addClass('show');
		return false;

	}

	return true;
	/*if (($('#password').val() && $('#cpassword').val())
			&& ($('#password').val() != ($('#cpassword').val()))) {
		setErrorMessage("Passwords enterd do not match");
		return false;
	} else {
		return true;
	}*/

}

function setErrorMessage(msg) {

	$("#error").text(msg);
	$("#error").removeClass('hidden');
	$("#error").addClass('show');

}