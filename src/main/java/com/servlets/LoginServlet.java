package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entities.User;
import com.helper.ConnectionProvider;

@WebServlet("/LoginServlet")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String email = request.getParameter("login_user_mail");
			String password = request.getParameter("login_user_pass");
			Connection connection = ConnectionProvider.getConnection();
			UserDao currDao = new UserDao(connection);
			User currUser = currDao.getUser(email, password);
			if(currUser == null) {
				out.print("-1");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("currUser", currUser);
				out.print("1");
//				response.sendRedirect("profile.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
