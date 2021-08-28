package com.tomcat;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class divServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//		int d = Integer.parseInt(req.getParameter("d"));
//		
//		PrintWriter out = res.getWriter(); 
//		
//		out.println("The value of div = " +d);
		
		
//		HttpSession session = req.getSession(); 
//		int div = (int)session.getAttribute("d");
//		
//		PrintWriter out = res.getWriter(); 
//		out.println("The value of div is :"+div);
		
		String value = req.getParameter("initializeText");
		
		res.getWriter().println(value);
		
		Cookie cookies[] =req.getCookies(); 
		int div = 0; 
		
		for(Cookie c:cookies) {
			if(c.getName().equals("d")) {
				div = Integer.parseInt(c.getValue()); 
			};
		}
		
		res.setContentType("text'html");
		
		PrintWriter out = res.getWriter(); 
		out.println("<h1>The value of d is "+div+"</h1>");
		
		System.out.println("divServlet Called!");
	}
	
	
}
