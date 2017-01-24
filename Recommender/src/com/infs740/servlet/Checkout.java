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

import com.infs740.dao.DbOperations;
import com.infs740.model.Cart;
import com.infs740.model.Products;
import com.mongodb.client.FindIterable;
import com.infs740.mail.*;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CheckoutServlet");
		DbOperations db = new DbOperations();
		Object user_id = "5833e7d5a3028e3433c61211";
		FindIterable<Document> usersList = db.loadCart(user_id);
		List<Products> cart = new ArrayList<Products>();
		List<Cart> quantity = new ArrayList<Cart>();
		SetPropertiesFile pro=new SetPropertiesFile();
		Products p= new Products();

		float amt = 0;
		for (Document document : usersList) {
			Cart c=new Cart();

			c.setUsers(Integer.parseInt((document.get("users")).toString()));
			c.setRemind((document.get("remind")).toString());
			quantity.add(c);
			p=db.findProduct(document.get("item_id").toString(), document.get("items").toString());
			cart.add(p);
			}
		float tax=27* amt/100;
		float total=amt+tax;
		//pro.setProps("kadam93.sani@gmail.com", "20s", "skadam");
		request.setAttribute("cart", cart);
		request.setAttribute("quantity", quantity);
		request.setAttribute("amt", amt);
		request.setAttribute("tax", tax);
		request.setAttribute("total", total);
		RequestDispatcher rd = request.getRequestDispatcher("/Payment.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
