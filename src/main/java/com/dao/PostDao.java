package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import com.entities.Post;
import com.entities.User;
import com.entities.UserPost;
import com.helper.ConnectionProvider;


public class PostDao {
	private Connection connection;

	public PostDao(Connection connection) {

		this.connection = connection;
	}
	
	public UserPost getUserPost(User user) {
		ArrayList<Post> posts = getPosts(user);
		UserPost userPost = new UserPost(posts, user);
		return userPost;
	}

	public ArrayList<Post> getPosts(User user){
		try {
		ArrayList<Post> posts = new ArrayList<>();
		String query = "select * from posts where userId = ? ;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				
				String title = result.getString("title");
				String content = result.getString("content");
				String code = result.getString("code");
				Timestamp postDate = result.getTimestamp("postDate");
				int catId = result.getInt("catId");
				int pid = result.getInt("pid");
				
				Post post = new Post(pid, catId, user.getId(), title, content, code, postDate);
				posts.add(post);
				
				
				
			}
			
			return posts;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
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
