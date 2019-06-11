var count = 0;
function getSensorStatus(id,tagId){
	
	//console.log("id==>"+$('#'+tagId).attr('checked'));
	var status;
	if( $('#'+tagId).attr('checked') == "checked"){
		status = "0";
		lightcheck(id,"off");
		$('#'+tagId).removeAttr('checked');
		$('#'+tagId).attr('unchecked','unchecked');
	}else{
		status = "1";
		lightcheck(id,"on");
		$('#'+tagId).removeAttr('unchecked');
		$('#'+tagId).attr('checked','checked');
	}
	$.ajax({
		  type: "POST",
		  url: "updateStatus",
		  data: { id: id, status: status }
		}).done( function( msg ) {
		  
			if(msg.indexOf("success") != -1){
				console.log("Updated Successfully");
			}else if(msg.indexOf("login") != -1){
				window.location.href = "/smarthome/login";
			}
			
	
		});    
}

function lightcheck(tagId, status){
	
	if($('#img'+tagId).attr("src").indexOf("light") != -1){
		
		
		$('#img'+tagId).attr("src","images/light_"+status+".png?id="+count);
		count++;
	}
}


function addhome(){
	
	console.log("add home");
	
	var housename = $('#homename').val();
	var street = $('#street').val();
	var city = $('#city').val();
	var country = $('#country').val();
	var zipcode = $('#zipcode').val();
	
	

		/* validating the value of email
			1. empty check for email
			2. @ check
			3. . check
			4. string present between start point of email and @
			5. string present between . and end of email
			6. string present between @ and .
		*/
		if(typeof undefined == typeof housename || null == housename || "" == housename ){
			/*$("#homeerror").text(" Please enter House Name");
			$("#homeerror").removeClass('hidden');
			$("#homeerror").addClass('show');*/
		}else if(typeof undefined == typeof street || null == street || "" == street ){
			/*$("#homeerror").text("Please enter Street");
			$("#homeerror").removeClass('hidden');
			$("#homeerror").addClass('show');*/
		}else if(typeof undefined == typeof city || null == city || "" == city ){
			/*$("#homeerror").text("Please enter City");
			$("#homeerror").removeClass('hidden');
			$("#homeerror").addClass('show');*/
		}else if(typeof undefined == typeof country || null == country || "" == country ){
			/*$("#homeerror").text("Please enter Country");
			$("#homeerror").removeClass('hidden');
			$("#homeerror").addClass('show');*/
		}else if(typeof undefined == typeof zipcode || null == zipcode || "" == zipcode ){
			/*$("#homeerror").text("Please enter Zipcode");
			$("#homeerror").removeClass('hidden');
			$("#homeerror").addClass('show');*/
		}else{
			document.getElementById('addHomeModal').style.display='none';
			
			
		}
}

function gethomeid(apartmentId){
	
	$('#apartmentId').val(apartmentId);
}

function getroomid(roomId){
	
	$('#roomId').val(roomId);
}

function saveSensor(){
	
	
	var name = $('#name').val();
	var sensorType = $('#sensorType').val();
	var roomId = $('#roomId').val();
	
	if(typeof undefined == typeof sensorType || null == sensorType || "" == sensorType ){
		/*$("#homeerror").text(" Please enter House Name");
		$("#homeerror").removeClass('hidden');
		$("#homeerror").addClass('show');*/
	}else if(typeof undefined == typeof name || null == name || "" == name ){
		/*$("#homeerror").text("Please enter Street");
		$("#homeerror").removeClass('hidden');
		$("#homeerror").addClass('show');*/
	}else if(typeof undefined == typeof roomId || null == roomId || "" == roomId ){
		/*$("#homeerror").text("Please enter Street");
		$("#homeerror").removeClass('hidden');
		$("#homeerror").addClass('show');*/
	}else{
		document.getElementById('addSensorModal').style.display='none';
	}
	
	
}


function saveRoom(){
	
	
	var name = $('#name').val();
	var roomType = $('#roomType').val();
	var apartmentId = $('#apartmentId').val();
	
	if(typeof undefined == typeof roomType || null == roomType || "" == roomType ){
		/*$("#homeerror").text(" Please enter House Name");
		$("#homeerror").removeClass('hidden');
		$("#homeerror").addClass('show');*/
	}else if(typeof undefined == typeof name || null == name || "" == name ){
		/*$("#homeerror").text("Please enter Street");
		$("#homeerror").removeClass('hidden');
		$("#homeerror").addClass('show');*/
	}else if(typeof undefined == typeof apartmentId || null == apartmentId || "" == apartmentId ){
		/*$("#homeerror").text("Please enter Street");
		$("#homeerror").removeClass('hidden');
		$("#homeerror").addClass('show');*/
	}else{
		document.getElementById('addRoomModal').style.display='none';
	}
	
	
}

