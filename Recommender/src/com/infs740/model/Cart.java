package com.infs740.model;

public class Cart {
	private String user_id;
	private String _id;
	private String item_id;
	private String items;
	private int users;
	private String remind;

	public Cart (String user_id, String _id, String item_id, String items,
			int users, String remind) {
		this.user_id=user_id;
		this._id=_id;
		this.item_id=item_id;
		this.items=items;
		this.users=users;
		this.remind=remind;
	}
	
	public Cart() {
		
	}
	
	public void set_id(String _id) {
		this._id=_id;
	}
	
	public String get_id() {
		return _id;
	}
	
	public void setItem_id(String item_id) {
		this.item_id=item_id;
	}
	
	public String getItem_id() {
		return item_id;
	}
	public void setUser_id(String user_id) {
		this.user_id=user_id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setItems(String items) {
		this.items=items;
	}
	
	public String getItems() {
		return items;
	}
	
	public void setUsers(int users) {
		this.users=users;
	}
	
	public int getUsers() {
		return users;
	}
	
	public void setRemind(String remind) {
		this.remind=remind;
	}
	
	public String getRemind() {
		return remind;
	}
}
