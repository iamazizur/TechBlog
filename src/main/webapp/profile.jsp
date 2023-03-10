<%@page import="com.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.dao.CategoryDao"%>
<%@page import="com.entities.User"%>
<%@page import="java.nio.file.FileSystems"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp"%>


<%
User currUser = (User) session.getAttribute("currUser");
if (currUser == null)
	response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="styles.jsp"%>
 <!-- icons -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<title>TechBlog:Profile</title>
</head>
<body>

	<!-- navbar -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp">Tech Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<!-- button for opening post modal -->

				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#postModal">Publish Post</button>
				<!-- button for opening post modal -->
			</ul>

			<ul class="navbar-nav mr-right">
				<li class="nav-item active"><a class="nav-link" href="#"
					data-toggle="modal" data-target="#user_modal" id="user_modal"> <%=currUser.getName()%>
						<span class="sr-only">(current)</span>
				</a></li>


				<li><a href="Logout" class="btn btn-danger">Logout</a></li>
			</ul>




		</div>
	</nav>

	<!--navebar  -->
	<!-- modal  user edit-->

	<div class="modal" tabindex="-1" id="user_modal">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<!-- img -->
					<%
					String path = request.getServletContext().getRealPath("/") + "images" + FileSystems.getDefault().getSeparator()
							+ currUser.getProfile();
					%>
					<div class="card ">
						<img src="<%=path%>" class="rounded mx-auto d-block" alt="..."
							style="width: 100px; border-radius: 50%;">


					</div>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<!--img  -->

				</div>


				<div class="modal-body">
					<h5 class="modal-title"><%=currUser.getName()%></h5>

					<p><%=currUser.getAbout()%></p>
					<!-- table -->
					<!--user details  -->
					<div id="user_details">
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Email</th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row" id="user_details_id"><%=currUser.getId()%></th>
									<td><%=currUser.getEmail()%></td>

								</tr>

							</tbody>
						</table>
					</div>
					<!--user details  -->
					<!-- user edit -->
					<div id="user_edit_details">
						<form action="EditUser" id="form_update_info">
							<div class="card-body">
								<div class="mb-3">
									<label for="inp_edit_pass" class="form-label">Password</label>
									<input type="password" name="update_pass" class="form-control"
										id="inp_edit_pass">
								</div>
								<div class="mb-3">
									<label for="inp_edit_pass" class="form-label">Password</label>

								</div>
								<div class="mb-3">
									<label for="inp_edit_about" class="form-label">About Me</label>


									<textarea rows="5" class="form-control mb-2" cols="30"
										placeholder="Tell us something about yourself"
										id="inp_edit_about" name="update_about"><%=currUser.getAbout()%></textarea>


									<label for="user_inp_file" class="form-label">Profile
										Pic</label> <input type="file" id="user_inp_file" name="user_inp_file"
										class="mb-5">



									<button type="submit" class="btn btn-primary"
										id="btn_submit_user_edit">Update</button>


								</div>
							</div>
						</form>
					</div>

					<!-- user edit -->

					<!-- table -->
				</div>
				<div class="modal-footer" id="user_edit_footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="btn_user_edit">Edit</button>
				</div>
			</div>
		</div>
	</div>

	<!-- modal -->

	<!-- modal add post  -->



	
	<%@include file="addPostModal.jsp"  %>
	

	<!-- modal add post  -->
	
	<!--user's posts  -->
	<%@include file="userPosts.jsp" %>
	<!--user's posts  -->


	<%
	out.print(currUser.toString());
	%>








	<%@include file="scripts.jsp"%>
	<script type="text/javascript" src="js/edit_user.js"></script>
	<script type="text/javascript" src="js/categories.js"></script>
	<script type="text/javascript" src="js/post.js"></script>
</body>
</html>