

$(document).ready(function() {
	$('#form_add_post').submit(function(event) {
		event.preventDefault();
		const form = this;

		submitPostToDB(form).then((data) => {
			alert('post added successfully');
			

		}).catch((e) => {
			alert('some error occured : ' + e[0])
			console.log(e);
		})
	})

	getPosts()
		.then((response) => {
			alert('got posts successfully');
			console.log(response);
			const user = response['user']
			const posts = response['posts']
			getPostElement(user.name, posts)
		 })
		.catch((e) => console.log(e))
})


const getPostElement = (username,posts) => {
	const container = document.getElementById('user_posts_container');
	container.innerText = '';
	posts.forEach((post) => {
		const postDate = post['postDate'];
		const title = post['title'];
		const content = post['content']
		const code = post['code']
		let updatedCode = '';
		
		for(let i=0; i<code.length; i++){
			updatedCode += code.charAt(i);
			if(code.charAt(i) === ';')
				updatedCode += '<br>';
			
		}
		
		const element = `<div class="container-fluid mt-3">

		<div class="card">
			<div class="card-header">
				<div class="row">
					<div class="col-sm-8">
						Author :
						${username}</div>
					<div class="col-sm-4 text-right">
						Posted on :
						${postDate}</div>
				</div>

			</div>
			<div class="card-body">
				<h5 class="card-title">${title}</h5>
				<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
				<p class="card-text">${content}</p>
				<p>
					<code>${updatedCode}</code>
				</p>
				<button type="button" class="btn btn-primary">
					<i class="bi bi-heart-fill"></i> 4
				</button>

			</div>
		</div>

	</div>`
	
	container.innerHTML += element;
	})
	
	
}








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


const getPosts = () => new Promise((resolve, reject) => {
	$.ajax({
		url: 'GetPosts',
		type: 'POST',
		data: '',
		success: function(data, status, jqXHR) {

			if (status === 'success')
				resolve(data);
			else
				reject([data, status, jqXHR])

		},
		error: function(data, status, jqXHR) {
			alert('error');
			reject(reject([data, status, jqXHR]));
		}
	})
})


