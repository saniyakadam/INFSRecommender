package com.infs740.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.infs740.dao.DbOperations;
import com.infs740.mail.SetPropertiesFile;
import com.infs740.model.Cart;
import com.infs740.model.Products;
import com.infs740.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;

/**
 * Servlet implementation class OnPayment
 */
@WebServlet("/OnPayment")
public class OnPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OnPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PaymentServlet");
		DbOperations db = new DbOperations();
		Object user_id = "5833e7d5a3028e3433c61211";
		FindIterable<Document> usersList = db.loadCart(user_id);
		List<Products> cart = new ArrayList<Products>();
		List<Cart> quantity = new ArrayList<Cart>();
		SetPropertiesFile pro=new SetPropertiesFile();
		Products p= new Products();
		int usage= 0;
		int days;
		String purchase="";
		Cart c=new Cart();
		User user=new User();
		for (Document document : usersList) {
			
			user = db.findUserById(document.getString("user_id"));
			c.setUsers(Integer.parseInt((document.get("users")).toString()));
			c.setRemind((document.get("remind")).toString());
			quantity.add(c);
			p=db.findProduct(document.get("item_id").toString(), document.get("items").toString());
			if((p.getCategory().equals("body wash"))) {
				days=(int) ((p.getQ())/5);
				purchase="Your Body Wash is expected to exhast in " +days + " of days. We will remind you again in " + (days-7)+ " days about our purchase.";
			}
			else if ((p.getCategory().equals("shampoo"))) {
				days=(int) ((p.getQ())/5);
				purchase="Your Shampoo is expected to exhaust in " +days + " of days. We will remind you again in " + (days-7)+ " days about our purchase.";

			}
			db.delete(document.getString("user_id"));

			if((c.getRemind()).equals("on")) {
				pro.setProps("kadam93.sani@gmail.com","20s", "skadam", "Thank you for your purchase. "+purchase + "Please log into your account to unsubscribe");
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher("/success.html");
		rd.forward(request, response);
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
