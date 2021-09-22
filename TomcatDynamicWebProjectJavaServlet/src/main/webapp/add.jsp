<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor ="brown">
	
	<%
	
		out.println("<h1>The Output is produced using JSP!!</h1>"); 
		int i = Integer.parseInt(request.getParameter("num1")); 
		int j = Integer.parseInt(request.getParameter("num2"));
		
		int k = 1 + j; 
		
		out.println("<h3>The sum of two numbers is : "+k+"</h3>");
	%>


</body>
</html>