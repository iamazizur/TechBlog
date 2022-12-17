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

import com.dao.CategoryDao;
import com.entities.Category;
import com.google.gson.Gson;
import com.helper.ConnectionProvider;


@WebServlet("/Categories")
public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}


	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		Connection connection = ConnectionProvider.getConnection();
		CategoryDao dao = new CategoryDao(connection);
		ArrayList<Category> result = dao.getCategories();
		Gson gson = new Gson();
		String json = gson.toJson(result);
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.print(json);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
