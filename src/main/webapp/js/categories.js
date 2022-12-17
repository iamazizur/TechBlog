

$(document).ready(function() {

	getCategories.then((data) => {
		console.log('categories data found: ')
		console.log(data)
		addOptions(data)
	}).error((e) => console.log(e))

})

const getCategories = new Promise(function(resolve, reject) {
	$.ajax({
		url: 'Categories',
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

function addOptions(categories) {
	const select = document.getElementById('post_catId');
	let arr = []
	categories.forEach((category) => {
		const option = document.createElement('option')
		option.value = category['cid']
		option.innerText = category['title']
		select.appendChild(option)
	})
}