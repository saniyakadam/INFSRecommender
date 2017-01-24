package com.infs740.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.infs740.dao.DbOperations;
import com.infs740.model.Products;
import com.mongodb.client.FindIterable;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CartServlet");
		DbOperations db = new DbOperations();
		ArrayList<Object> item = new ArrayList<Object>();
		ArrayList<Object> itemFromDb=new ArrayList<Object>();
		Object user_id = "5833e7d5a3028e3433c61211";
		Products p=new Products();
		FindIterable<Document> usersList = db.loadCart(user_id);
		float total = 0;
		for (Document document : usersList) {
			Object obj = new Object();
			obj = document.get("item_id");
			item.add(obj);
			p=db.findProduct(document.get("item_id").toString(), document.get("items").toString());
			/*Object object=new Object();
			object=items.get(0).getObjectId("_id");
			itemFromDb.add(object);
			object=items.get(0).getString("desc");;
			itemFromDb.add(object);
			object=items.get(0).getString("use");;
			itemFromDb.add(object);
			object=items.get(0).getString("rating");;
			itemFromDb.add(object);
			object=items.get(0).getString("price");;
			total+=Float.parseFloat(items.get(0).getString("price"));
			itemFromDb.add(object);
			object=document.get("users");
			itemFromDb.add(object);
			object=document.get("remind");
			itemFromDb.add(object);
			*/
			itemFromDb.add(p.getProductName());
			itemFromDb.add(p.getAddress());
			itemFromDb.add(p.getDescription());
			itemFromDb.add(p.getUse());
			itemFromDb.add(p.getRating());
			itemFromDb.add(p.getPrice());
			itemFromDb.add(p.getImage());
			total+=(p.getPrice());
			itemFromDb.add(document.get("users"));
			itemFromDb.add(document.get("remind"));
			
		}
		/*request.setAttribute("total", total);
		response.setContentType("application/JSON");
		PrintWriter out = response.getWriter();
		String json = new Gson().toJson(itemFromDb);
		System.out.print(json);
		out.print(json);*/
		
		String json1 = new Gson().toJson(itemFromDb); 
		String json2 = new Gson().toJson(total); 
		response.setContentType("application/json"); 
		//response.setCharacterEncoding("utf-8"); 
		String bothJson = "["+json1+","+json2+"]"; //Put both objects in an array of 2 elements
		response.getWriter().write(bothJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
