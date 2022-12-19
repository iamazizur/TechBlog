package com.entities;

import java.util.ArrayList;

public class UserPost {
	private ArrayList<Post> posts;
	private User user;
	
	public UserPost(ArrayList<Post> posts, User user) {
		this.posts = posts;
		this.user = user;
	}

	public UserPost(User user) {
		this.user = user;
	}

	public UserPost() {
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPost(ArrayList<Post> posts) {
		this.posts = posts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
}
