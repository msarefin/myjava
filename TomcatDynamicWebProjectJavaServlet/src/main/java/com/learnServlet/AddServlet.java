package com.learnServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		 
		int k= i+j; 
		// Http Session

		HttpSession session = req.getSession(); 
		session.setAttribute("k", k);
		
	}
	
	
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		 
//		int k= i+j; 
//		// using redirect
//		res.sendRedirect("sq?k="+k);
//		
//	}

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k= i+j; 
//		
//		req.setAttribute("FromAddServlet", k); 
//		// transfering data from parent servlet by setting a value to a request parameter
//		// Using RequestDispatcher
//		RequestDispatcher rd = req.getRequestDispatcher("sq"); 
//		rd.forward(req, res);
//	}
	
	
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k= i+j; 
//			//This method will force the use of get method
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>The sum of two numbers is :"+k+"</h1>");
//	}
	
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k= i+j; 
//			//This method will force page to only user post method	
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>The sum of two numbers is :"+k+"</h1>");
//	}
	
//	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k= i+j; 
//			//This method will default just allow the webpage to determine whether to use get or post service
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>The sum of two numbers is :"+k+"</h1>");
//	}
}
