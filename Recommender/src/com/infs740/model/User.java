package com.infs740.model;

import org.bson.types.ObjectId;

public class User {

	private String username;
	private String password;
	private ObjectId id;
	private String email;
	
	public User(String name, String pass, String email) {
		username=name;
		password=pass;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public void setId(ObjectId id) {
		this.id=id;
	}

	public ObjectId getId() {
		return id;
	}
	public void setUsername(String name) {
		username=name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String pass) {
		password=pass;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}

	
}
