package com.tomcat;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




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
		
		int k = sum *sum; 
		
		req.setAttribute("k", k);
		
		RequestDispatcher rd  = req.getRequestDispatcher("sq");
		rd.forward(req, res);
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
