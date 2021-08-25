package com.tomcat;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class AddServlet extends HttpServlet {

//	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int sum = i+j ; 
//		
//		PrintWriter out = res.getWriter(); 
//		out.println("Your Sum is :"+sum);
//	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int sum = i + j;

		PrintWriter out = res.getWriter();
		out.println("Your Sum is :" + sum);
		
//		int k = sum *sum; 
//		
//		req.setAttribute("k", k);
//		
//		RequestDispatcher rd  = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
		int d = i/j; 
//		
//		res.sendRedirect("div?d="+d);
		
		
//		HttpSession session = req.getSession();
//		session.setAttribute("d", d);
//		res.sendRedirect("div");
		
		Cookie cookie = new Cookie("d", d+"");
		res.addCookie(cookie);
		
		res.sendRedirect("div");
		
	}

//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//
//		int sum = i + j;
//
//		PrintWriter out = res.getWriter();
//		out.println("Your Sum is :" + sum);
//	}
}