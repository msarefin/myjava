package com.tomcat;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
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

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int sum = i + j;

		PrintWriter out = res.getWriter();
		out.println("Your Sum is :" + sum);
		
		RequestDispatcher
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
