package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import com.entities.Post;


public class PostDao {
	private Connection connection;

	public PostDao(Connection connection) {

		this.connection = connection;
	}

	public String createPost(Post post) {
		try {
			
			String query = "INSERT INTO posts(title,content,code,postDate,catId,userId) values(?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setString(2, post.getContent());
			preparedStatement.setString(3, post.getCode());
			preparedStatement.setTimestamp(4, post.getPostDate());
			preparedStatement.setInt(5, post.getCatid());
			preparedStatement.setInt(6, post.getUserId());
			
			preparedStatement.execute();
			return "true";
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
