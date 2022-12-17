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

import com.dao.UserDao;
import com.entities.User;
import com.helper.ConnectionProvider;


@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String result = "";
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String agreement = (String) request.getParameter("agreement"); // on || null
			
			if(agreement == null) {
				out.print("You need to agree terms & Conditions");
				return;
			}
			String name = (String) request.getParameter("user_name");
			if(name.isEmpty()) name = null;
			String email = (String) request.getParameter("user_mail");
			if(email.isEmpty()) email = null;
			String password = (String) request.getParameter("user_pass");
			if(password.isEmpty()) password = null;
			String about = (String) request.getParameter("about");
			
			User currUser = new User(name, email, password, about);
			Connection connection = ConnectionProvider.getConnection();
			UserDao currUserDao = new UserDao(connection);
			String responseResult = currUserDao.insertUser(currUser);
			
			out.print(responseResult);
			
			
		} catch (Exception e) {
			result += e.getMessage() +"\n";
			
			e.printStackTrace();
			System.out.println(result);
		}
		
		
	}

}
