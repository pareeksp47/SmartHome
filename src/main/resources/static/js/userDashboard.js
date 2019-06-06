function getSensorStatus(id,tagId){
	
	console.log("id==>"+$('#'+tagId).attr('checked'));
	var status;
	if($('#'+tagId).attr('checked') == "checked"){
		status = "0";
	}else{
		status = "1";
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

