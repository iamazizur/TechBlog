package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PostDao;
import com.entities.Post;
import com.entities.User;
import com.entities.UserPost;
import com.google.gson.Gson;
import com.helper.ConnectionProvider;


@WebServlet("/GetPosts")
public class GetPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("currUser");
			PrintWriter out = response.getWriter();
			
			if(user == null)
			{
				out.print("-1");
				return;
			}
			
			Connection connection = ConnectionProvider.getConnection();
			PostDao dao = new PostDao(connection);
			UserPost userPost = dao.getUserPost(user);
			response.setContentType("application/json");
			Gson gson = new Gson();
			String json = gson.toJson(userPost);
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print(e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
