

console.log("Hello")

$('#form_register').submit(function(event){
		
		event.preventDefault();
		let form = $(this);
		let serialized = form.serialize();
		let actionUrl = form.attr('action')
		
		$.ajax({
			type : 'POST',
			url : actionUrl,
			data : serialized,
			success : function(response, textStatus, jqXHR){
				console.log(response);
				console.log(textStatus);
				console.log(jqXHR);
				if(response === '1'){
					alert('Successfully registered')
					window.location = 'login.jsp'
				}
				
				
				else
				alert(response)
			},
			error : function(e){
				console.log(e.get_message())
			}
		})
			  
	})
	
	
	$('#form_login').submit(function(event){
		event.preventDefault();
		let form = $(this);
		let formData = new FormData(this);
		
		let actionUrl = form.attr('action')
		
		console.log(formData)
		
		
	
		$.ajax({
			url : actionUrl,
			type : 'POST',
			data : formData,
			processData : false,
			contentType : false,
			success : function(data,textStatus, jqXHR){
				console.log(data)
				if(data === '1'){
					alert('success');
					window.location = 'profile.jsp'
				}
				else alert('User Not Found!')
				console.log(textStatus)
				console.log(jqXHR)
			},
			error : function(data,textStatus, jqXHR){
				alert('error')
				console.log(data)
				console.log(textStatus)
				console.log(jqXHR)
			}
		})
	})
	
	
	
	
	
	
	
	
	
	