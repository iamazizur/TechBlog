package com.entities;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	private String profile;
	private Timestamp reg_date;

	public User() {

	}

	public User(int id, String name, String email, String password, String about, Timestamp reg_date) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.reg_date = reg_date;
	}

	public User(String name, String email, String password, String about) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;

		Instant i = new Date().toInstant();

		Timestamp t = Timestamp.from(i);
		reg_date = t;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
				+ ", reg_date=" + reg_date + ", profile= +" + profile + "]";
	}
}
