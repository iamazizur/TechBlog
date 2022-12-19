package com.helper;

import java.util.Comparator;

import com.entities.Post;

public class PostComparator implements Comparator<Post> {

	@Override
	public int compare(Post post1, Post post2) {
		return post1.getPostDate().compareTo(post2.getPostDate()) * -1;
		
	}

}
