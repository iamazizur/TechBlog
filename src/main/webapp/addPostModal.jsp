
	<!-- Modal -->

	<div class="modal fade" id="postModal" tabindex="-1"
		aria-labelledby="postModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">New Post</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<!-- header -->

				<!-- body -->
				<div class="card">

					<div class="modal-body">

						<!-- form -->
						<form action="AddPost" id="form_add_post">

							<div class="mb-3 form-group">
								<label for="post_catId" class="form-label">Category</label>
								<select
									class="form-control" id="post_catId" name="post_catId">
									<%-- <%
									CategoryDao dao = new CategoryDao(ConnectionProvider.getConnection());
									ArrayList<Category> categories = dao.getCategories();

									for (Category category : categories) {
									%>
									<option value=<%=category.getCid() %>><%=category.getTitle()%></option>
									<%
									}
									%> --%>
								</select>
							</div>
							<!--title  -->
							<div class="mb-3">
								<label for="post_title" class="form-label">Title</label> <input
									type="text" name="post_title" class="form-control"
									id="post_title">
							</div>


							<div class="mb-3">
								<label for="post_description" class="form-label">Description</label>
								<textarea rows="5" class="form-control mb-2" cols="30"
									placeholder="Add your thoughts" id="post_description"
									name="post_description"></textarea>
							</div>


							<div class="mb-3">
								<label for="post_code" class="form-label">Code</label>
								<textarea rows="5" class="form-control mb-2" cols="30"
									placeholder="Add your codes, if any.." id="post_code"
									name="post_code"></textarea>
							</div>

							<button type="submit" class="btn btn-primary">Add Post</button>
						</form>

						<!-- form -->
					</div>
				</div>

				<!-- body -->


				<!-- footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>

				<!-- footer -->
			</div>
		</div>
	</div>


