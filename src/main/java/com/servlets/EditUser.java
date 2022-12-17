package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import com.dao.UserDao;
import com.entities.User;
import com.helper.ConnectionProvider;
import com.helper.Helper;


@WebServlet("/EditUser")
@MultipartConfig
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}


	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("currUser");
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String password = request.getParameter("update_pass");
			if(password.isEmpty() == false) {
				user.setPassword(password);
			}
			
			String about = request.getParameter("update_about");
			user.setAbout(about);
			
			
			Part imageFile = request.getPart("user_inp_file");
			
			String fileName = imageFile.getSubmittedFileName();
			user.setProfile(fileName);
			
			System.out.println(user.toString());
			
			Connection connection = ConnectionProvider.getConnection();
			UserDao dao = new UserDao(connection);
			
			boolean result = dao.updateUserInfo(user);
			if(result) out.print("1");
			else out.print("-1");
			
			String path = request.getServletContext().getRealPath("/") + "images" + FileSystems.getDefault().getSeparator() + user.getProfile();
			Helper.deleteFile(path);
			boolean isFileUploaded = Helper.saveFile(imageFile, path);
			System.out.println(isFileUploaded);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
