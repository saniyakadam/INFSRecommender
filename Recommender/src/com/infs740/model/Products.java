package com.infs740.model;

public class Products {

	private String productName;
	private String description;
	private float price;
	private String use;
	private String relevance;
	private String rating;
	private String address;
	private String image;
	private String id;
	private int q;
	private String category;
	
	
	public Products (String prod_name, String desc, float price,
			String use, String rel, String rating, String address, String image, String id, int q, String category) {
		productName=prod_name;
		description=desc;
		this.price=price;
		this.use=use;
		relevance=rel;
		this.rating=rating;
		this.address=address;
		this.image=image;
		this.id=id;
		this.q=q;
		this.category=category;
	}
	
	public Products() {
		
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setProductName(String prod_name) {
		productName=prod_name;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setDescription(String desc) {
		description=desc;
	}
	
	public String getDescription() {
		return description;
	}
	public void setUse(String use) {
		this.use=use;
	}
	
	public String getUse() {
		return use;
	}
	
	public void setPrice(float price) {
		this.price=price;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setRelevance(String relevance) {
		this.relevance=relevance;
	}
	
	public String getRelevance() {
		return relevance;
	}
	
	public void setRating(String rating) {
		this.rating=rating;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setImage(String image) {
		this.image=image;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setQ(int q) {
		this.q=q;
	}
	
	public float getQ() {
		return q;
	}
	
	public void setCategory(String category) {
		this.category=category;
	}
	
	public String getCategory() {
		return category;
	}
	
}
