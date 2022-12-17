<%@page import="com.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Insert title here</title>
</head>
<body>
	<!-- Navbar -->
	<%@include file="nav.jsp"%>

	<%
	User user = (User) session.getAttribute("currUser");
	int loggedIn = (user == null) ? 0 : 1;
	System.out.println(user);
	%>
	<!-- banner -->

	<div class="container-fluid m-0 p-0">
		<div class="jumbotron">
			<h3>Welcome To Tech Blog</h3>
			<p>World of all technical blogs</p>



			<a href="login.jsp" type="button" class="btn btn-primary">Login</a> <a
				href="register.jsp" type="button" class="btn btn-primary">Register</a>


			<a href="profile.jsp" type="button" class="btn btn-primary">My
				Profile</a>


		</div>
	</div>


	<div class="container">

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<h5 class="card-title">Java Programming Language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Read More..</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<h5 class="card-title">Java Programming Language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Read More..</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<h5 class="card-title">Java Programming Language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Read More..</a>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<h5 class="card-title">Java Programming Language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Read More..</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<h5 class="card-title">Java Programming Language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Read More..</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<h5 class="card-title">Java Programming Language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Read More..</a>
					</div>
				</div>
			</div>

		</div>



	</div>













	<%@include file="scripts.jsp"%>

</body>
</html>