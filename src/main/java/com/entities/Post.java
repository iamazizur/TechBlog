package com.entities;

import java.sql.Timestamp;

public class Post {
	private int pid;
	private int catid;
	private String title;
	private String content;
	private String code;
	private Timestamp postDate;
	
	public Post() {
		
	}

	public Post(int catid, String title, String content, String code, Timestamp postDate) {
		super();
		this.catid = catid;
		this.title = title;
		this.content = content;
		this.code = code;
		this.postDate = postDate;
	}

	public Post(int pid, int catid, String title, String content, String code, Timestamp postDate) {
		super();
		this.pid = pid;
		this.catid = catid;
		this.title = title;
		this.content = content;
		this.code = code;
		this.postDate = postDate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Post [pid=" + pid + ", catid=" + catid + ", title=" + title + ", content=" + content + ", code=" + code
				+ ", postDate=" + postDate + "]";
	}
	
	
	
	
	
	
	
}
