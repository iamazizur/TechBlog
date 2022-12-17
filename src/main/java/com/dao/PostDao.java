package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;


import com.helper.ConnectionProvider;

public class PostDao {
	private Connection connection;

	public PostDao(Connection connection) {

		this.connection = connection;
	}

	public boolean createPost(String title,String content,String code,int catId) {
		try {
			
			Instant instant = new Date().toInstant();
			Timestamp postDate = Timestamp.from(instant);
			
			
			connection = ConnectionProvider.getConnection();
			
			
			String query = "INSERT INTO posts(title,content,code,postDate,catId) values(?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, code);
			preparedStatement.setTimestamp(4, postDate);
			preparedStatement.setInt(5, catId);
			
			ResultSet result = preparedStatement.executeQuery();
			return result.first();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
