package com.learnServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SqServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	
	
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
////		using Coookies
//		Cookie cookies [] = req.getCookies(); 
//		int k = 0; 
//		for(Cookie c :cookies) {
//			if(c.getName().equals("k")) {
//				k= Integer.parseInt(c.getValue());
//			}
//				
//		}
//		int p = k*k; 
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>This is Http session from SqServlet</h1><br><i><h2>The value of the square is: "+p+"</h2></i>"); 
//	}

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//		// Http Session
//
//		HttpSession session = req.getSession();
//
//		int k = (int) session.getAttribute("k");
//		int p = k * k;
//		PrintWriter out = res.getWriter();
//		out.println("<h1>This is from SqServlet</h1><br><p><i>The Value of the square is: " + p + "</i></p>");
//	}

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		//using redirect
//		int k = Integer.parseInt(req.getParameter("k"));
//		
//		int r = k*k;
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>Hello from Sq Servlet !!!</h1>"+"<i>The value is : "+r+"</i>");
//		
//		
//	}

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		// using request Dispatcher
//		int k = (int) req.getAttribute("FromAddServlet"); 
//		//Receiving a value from the parent using the request parameter
//		int r = k; 
//		PrintWriter out = res.getWriter(); 
//		out.println("<h1>Hello from Sq Servlet !!!</h1><br><i>The value is: "+r*r+"</i>");
//		
//		
//	}
}
