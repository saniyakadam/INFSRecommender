/**package com.infs740.dao;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
 
import com.mongodb.DB;
import com.mongodb.MongoClient;
 
public class DbConnect throws Exception {
 
	private static DB mongoMgr;
	public static DB getInstance() {
		if (mongoMgr == null) {
			MongoClient mongo;
			try {
				// connect to mongodb server
				mongo = new MongoClient("localhost", 27017);
				// connect with the database
				mongoMgr = mongo.getDB("usermanager");
				System.out
						.println("Connect to database(usermanager) successfully");
			} catch (UnknownHostException e) {
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage());
			}
		}
		return mongoMgr;
}
}
**/