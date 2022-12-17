

$(document).ready(function() {
	$('#user_edit_details').hide();
	const btn_user_edit = document.getElementById('btn_user_edit');
	$(btn_user_edit).on('click', function(e) {
		const button = this;
		if (button.innerText === 'Edit') {
			$(this).html('Back')
			
			$('#user_details').hide();
		
			$('#user_edit_details').show();


		}
		else {
			$(this).html('Edit')
			$('#user_details').show();
			
			$('#user_edit_details').hide();

		}


	



	})
	
	$('#form_update_info').on('submit', function(event){
		event.preventDefault();
		const id = document.getElementById('user_details_id')
		console.log(id.innerHTML);
		
		const form = this;
		
		const actionUrl = $(this).attr('action')
		const formData = new FormData(form);
		formData.append('id', id.innerHTML)
		
		$.ajax({
			url : actionUrl,
			type : 'POST',
			data : formData,
			processData : false,
			contentType : false,
			success : function(data,textStatus, jqXHR){
				if(data === '1'){
					alert('success');
					window.location = 'profile.jsp'
				}
					
					
				
				console.log(data)
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

	
})