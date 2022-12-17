<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="styles.jsp"%>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<%@include file="nav.jsp"%>

	<main class="d-flex align-items-center" style="height: 90vh">
		<div class="container">
			<div class="col-md-6 offset-md-3">

				<div class="card">
					<div class="card-header text-center">
						<h3>Register Here!</h3>
					</div>
					<div class="card-body">

						<form action="RegisterServlet" method="post" id="form_register">
						<div class="mb-3">
							<label for="user_name" class="form-label">User Name</label> <input
								type="text" class="form-control" id="user_name"
								aria-describedby="emailHelp" name="user_name">

						</div>

						<div class="mb-3">
							<label for="user_mail" class="form-label">Email address</label> <input
								type="email" class="form-control" id="user_mail"
								aria-describedby="emailHelp" name="user_mail">

						</div>


						<div class="mb-3">
							<label for="user_pass" class="form-label">Password</label> <input
								type="password" class="form-control" id="user_pass"
								name="user_pass">
						</div>

						<div class="mb-3">
							<label for="about" class="form-label">About Me</label>
							<textarea rows="5" class="form-control" cols="30"
								placeholder="Tell us something about yourself" id="about"
								name="about"></textarea>
						</div>


						<div class="mb-3 form-check">
							<input type="checkbox" class="form-check-input" id="agreement" name="agreement">
							<label class="form-check-label" for="agreement">Agree
								Terms & Conditions</label>
						</div>


						<button type="submit" class="btn btn-primary">Submit</button>

						</form>
					</div>


				</div>


			</div>
		</div>
	</main>











	<%@include file="scripts.jsp"%>
</body>
</html>