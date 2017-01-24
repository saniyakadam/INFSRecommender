package com.infs740.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class hairservlet
 */
@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HairServlet");
		DbOperations db = new DbOperations();
		ArrayList<Object> l=new ArrayList<Object>();		
		FindIterable<Document> documents=db.findAllProducts("Shampoo");
		int i=0;
		for (Document document: documents) {
			Object obj=new Object();
			obj=document.get("_id");
			l.add(obj);
			obj=document.get("product_name");
			l.add(obj);
			obj=document.get("desc");
			l.add(obj);
			obj=document.get("price");
			l.add(obj);
			obj=document.get("use");
			l.add(obj);
			obj=document.get("rating");
			l.add(obj);
			obj=document.get("address");
			l.add(obj);
			obj=document.get("image");
			l.add(obj);
			i++;
		}
		response.setContentType("application/JSON");
		PrintWriter out=response.getWriter();
		String json=new Gson().toJson(l);
		System.out.print(json);
	     out.print(json);
		
		
		//for(Document document : documents){
          //  System.out.println(document);
        //}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
