<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<!-- css -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Login - TechBlog</title>
</head>
<body>
	<%@include file="nav.jsp"%>

	<main class="d-flex align-items-center" style="height : 70vh">

		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">

					<div class="card">
						<div class="card-header">
							<h3>Login</h3>
						</div>
						<div class="card-body">
							<form action="LoginServlet" method="post" id="form_login">
								<div class="mb-3">
									<label for="login_user_mail" class="form-label">Email
										address</label>
										<input type="email" name="login_user_mail" class="form-control"
										id="login_user_mail" aria-describedby="emailHelp">
									<div id="emailHelp" class="form-text">We'll never share
										your email with anyone else.</div>
								</div>
								<div class="mb-3">
									<label for="login_user_pass" class="form-label">Password</label>
									<input type="password" name="login_user_pass" class="form-control"
										id="login_user_pass">
								</div>
								<div class="mb-3 form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1"> <label class="form-check-label"
										for="exampleCheck1">Check me out</label>
								</div>
								<button type="submit" class="btn btn-primary">Login</button>
							</form>
						</div>

					</div>

				</div>
			</div>

		</div>

	</main>






	<%@include file="scripts.jsp" %>
</body>
</html>