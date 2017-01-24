package com.infs740.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.google.gson.Gson;
import com.infs740.dao.DbOperations;
import com.infs740.model.Products;
import com.mongodb.client.FindIterable;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Adding to cart");
		DbOperations db = new DbOperations();
		int people = 0;
		if ((request.getParameter("people")) != "") {
			people = Integer.parseInt(request.getParameter("people"));
		}

		String reminder = request.getParameter("reminder");
		if (reminder == null) {
			reminder = "off";
		}
		String addId = request.getParameter("id");
		try {
			db.addToCart(addId,request.getParameter(("item")), people, reminder);
		} catch (Exception e) {
			System.out.println(e);
		}
		FindIterable<Document> product = db.findAllProducts(request.getParameter(("item")));
		ArrayList<Object> list = new ArrayList<Object>();
		String str = null;
		for (Document document : product) {
			str = (document.get("relevance")).toString();
		}
		System.out.println("Relevance " + str);
		List<String> relevance = Arrays.asList(str.split(","));
		List<Products> suggestions = new ArrayList<Products>();
		System.out.println("Relevance " + relevance);
		Object obj = new Object();
		for (String rel : relevance) {
			FindIterable<Document> suggest = db.suggestProduct(rel);
			for (Document document : suggest) {
				Products p = new Products();
				p.setProductName(document.getString("product_name"));
				p.setDescription(document.getString("desc"));
				p.setUse(document.getString("use"));
				p.setRating(document.getString("rating"));
				p.setAddress(document.getString("address"));
				p.setImage(document.getString("image"));
				suggestions.add(p);
			}
		}
		request.setAttribute("addedToCart", "your item has been added to your cart. Some Items that you may like");
		request.setAttribute("suggestions", suggestions);
		RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
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
