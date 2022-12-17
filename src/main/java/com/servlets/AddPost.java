package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.entities.Post;
import com.helper.ConnectionProvider;
import com.helper.Helper;


@WebServlet("/AddPost")
@MultipartConfig
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			int catId = Integer.parseInt(request.getParameter("post_catId"));
			String title = request.getParameter("post_title");
			String content = request.getParameter("post_description");
			String code = request.getParameter("post_code");
			Timestamp postDate = Helper.getCurrTimeStamp();
			
			Post post = new Post(catId, title, content, code, postDate);
			
			PostDao dao = new PostDao(ConnectionProvider.getConnection());
			String postAdded = dao.createPost(post);
			
			
			PrintWriter out = response.getWriter();
			
			out.print(postAdded);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			try {
				PrintWriter out = response.getWriter();
				out.print(e.getMessage());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
