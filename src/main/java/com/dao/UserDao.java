package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.entities.User;

public class UserDao {
	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	//create user in database
	public String insertUser(User user) {
		
		try {
			
			String query = "insert into user(name,email,password,about,regDate) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getAbout());
			preparedStatement.setTimestamp(5, user.getReg_date());
			
			int response = preparedStatement.executeUpdate();
			String result = "";
			return result + response;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
			
			
		}
	}

	//get User
	public User getUser(String email, String password) {
		User user = null;
		try {
			String query = "select * from user where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email_from_set = result.getString("email");
				String password_from_set = result.getString("password");
				String about = result.getString("about");
				String profile = result.getString("profile");
				Timestamp regDate = result.getTimestamp("regDate");
				
				user = new User(id, name, email_from_set, password_from_set, about, regDate);
				user.setProfile(profile);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean updateUserInfo(User user) {
		try {
			
			String query = "UPDATE user SET password = ?, about = ?, profile = ? WHERE id = ?;";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getAbout());
			preparedStatement.setString(3, user.getProfile());
			
			preparedStatement.setInt(4, user.getId());
			boolean result = preparedStatement.execute();
			
			
			
			return !result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
