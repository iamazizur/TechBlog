

$(document).ready(function() {
	$('#form_add_post').submit(function(event) {
		event.preventDefault();
		const form = this;
		submitPostToDB(form).then((data) => {
			alert('post added successfully');
			console.log(data);
		}).catch((e) => {
			alert('some error occured : ' + e[0])
			console.log(e);
		})
	})
})

const submitPostToDB = (form) => new Promise((resolve, reject) => {
	const formData = new FormData(form);
	const actionUrl = form.getAttribute('action')
	$.ajax({
		url: actionUrl,
		type: 'POST',
		data: formData,
		contentType: false,
		processData: false,
		success: (data, status, jqXHR) => {
			if (status === 'success') {
				if (data === 'true')
					resolve(data);
				else
					reject([data, status, jqXHR])
			}
			else {
				reject([data, status, jqXHR])
			}
		},
		error: (data, status, jqXHR) => {
			reject([data, status, jqXHR])
		}
	})


})