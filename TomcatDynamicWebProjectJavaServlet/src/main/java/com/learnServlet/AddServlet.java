package com.learnServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int k = i + j;
		
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);
		res.sendRedirect("servAn");
	}

//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>Hello</h1>");
//		
//		// Servlet Config 
//		
//		ServletConfig con = getServletConfig(); 
//		String str = con.getInitParameter("name");
//		
//		out.println(str); 
//	}

//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>Hello</h1>");
//		
//		// Servlet Context 
//		
//		ServletContext ctx = getServletContext(); 
//		String str = ctx.getInitParameter("name"); 
//		out.println(str);
//		
//		ServletContext ctx1 = req.getServletContext(); 
//		str = ctx1.getInitParameter("phone"); 
//		out.println(str); 
//	}

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1")); 
//		int j = Integer.parseInt(req.getParameter("num2")); 
//		
//		// using Cuookies
//		int k = i+j; 
//		
//		Cookie cookie = new Cookie("k", k+"");
//		res.addCookie(cookie);
//		
//		res.sendRedirect("sq");
//	}

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//		//Http session
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//
//		int k = i + j;
//
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k); 
//		
//		res.sendRedirect("sq");
//
//	}

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
