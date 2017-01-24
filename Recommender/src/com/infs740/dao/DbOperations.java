package com.infs740.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;

import com.infs740.dao.*;
import com.infs740.model.Products;
import com.infs740.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class DbOperations {
	// DbConnect db=new DbConnect();
	MongoClient mongo;
	MongoDatabase db;
	

	public DbOperations() {

		mongo = new MongoClient();
		db = mongo.getDatabase("test");
		System.out.println("Connected to database");

	}
//finds user-login
	public User findUser(User user) {
		String name = user.getUsername();
		String password = user.getPassword();
		System.out.println("finding user");
		User result = new User();

		MongoCollection<Document> collection = db.getCollection("users");
		List<Document> documents = (List<Document>) collection.find(and(eq("username", name), eq("password", password)))
				.into(new ArrayList<Document>());

		/*for (Document document : documents) {
			System.out.println(document);
		}*/
		if (documents.size() != 0) {
			result.setId((documents.get(0)).getObjectId("_id"));
			result.setUsername((documents.get(0)).getString("username"));
			System.out.println(result.getUsername());
			System.out.println(result.getId());
			return result;
		} else
			return null;
	}
	
	public User findUserById(String id) {
		System.out.println("finding user");
		User result = new User();

		MongoCollection<Document> collection = db.getCollection("users");
		FindIterable<Document> documents =  collection.find();

		for (Document document : documents) {
		if((document.getObjectId("_id")).toString().equals(id)){
			result.setUsername(document.getString("username"));
			result.setEmail(document.getString("email"));
			}
		}
		return result;
	}

	
	public FindIterable<Document> findAllProducts(String itemName) {
		MongoCollection<Document> collection = db.getCollection("Products");
		Document regx = new Document();
		regx.append("$regex", "(?)" + Pattern.quote(itemName));
		regx.append("$options", "i");

		Document query = new Document("product_name", regx);
		FindIterable<Document> iterable = collection.find(query);
		for (Document document: iterable) {
			System.out.println(document);
		}
System.out.println("found product");
		
			return iterable;
	}

	public Products findProduct(String id, String prod_name) {
		MongoCollection<Document> collection = db.getCollection("Products");
		Document regx = new Document();
		regx.append("$regex", "(?)" + Pattern.quote(prod_name));
		regx.append("$options", "i");

		Document query = new Document("product_name", regx);
		FindIterable<Document> iterable = collection.find(query);		
		Products p=new Products();
		if (iterable != null) {
			for (Document document : iterable){
				if((document.getObjectId("_id").toString()).equals(id)) {
					p.setId(document.getObjectId("_id").toString());
					p.setProductName(document.getString("product_name"));
					p.setDescription(document.getString("desc"));
					p.setUse(document.getString("use"));
					p.setAddress(document.getString("address"));
					p.setRating(document.getString("rating"));
					p.setImage(document.getString("image"));
					p.setRelevance(document.getString("relevance"));
					p.setPrice(Float.parseFloat(document.getString("price")));
					p.setCategory(document.getString("category"));
					p.setQ(Integer.parseInt(document.getString("quantity")));
					return p;
				}
			}
		}
		 System.out.println(p.getProductName());		
		/*if (documents.size() != 0) {
			return documents;
		} else
			return null;*/
		return null;
	}

	public void addToCart(String item_id, String item, int users, String remind) {
		MongoCollection collection = db.getCollection("Cart");
		Document document = new Document();
		document.put("item_id", item_id);
		document.put("items", item);
		document.put("user_id", "5833e7d5a3028e3433c61211");
		document.put("users", users);
		document.put("remind", remind);
		
		try {
			   collection.insertOne(document);
			} catch (Exception e) {
			   System.out.println(e);
			};
			return ;
	}

	public FindIterable<Document> suggestProduct(String relevance) {
		MongoCollection<Document> collection = db.getCollection("Products");
		Document regx = new Document();
		regx.append("$regex", "(?)" + Pattern.quote(relevance));
		regx.append("$options", "i");

		Document query = new Document("product_name", regx);
		FindIterable<Document> iterable = collection.find(query);
		for (Document document: iterable) {
			System.out.println(document);
		}
System.out.println("found product");
		
			return iterable;
	}
	public  FindIterable<Document> loadCart(Object id) {
		Products product = new Products();
		MongoCollection<Document> collection = db.getCollection("Cart");
		FindIterable<Document> iterable = collection.find((eq("user_id", id)));
		for (Document document: iterable) {
			System.out.println(document);
		}
System.out.println("found product");
		
			return iterable;
		
	}
	
	public void delete(String id) {
		MongoCollection<Document> collection = db.getCollection("Cart");
		Bson filter = new Document("user_id", id);
		collection.deleteMany(filter);	
	}
}
