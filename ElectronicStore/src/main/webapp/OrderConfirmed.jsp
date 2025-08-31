<%@page import="com.customer.panel.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<%
CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");

int cost=(int)request.getAttribute("cost");

out.println(" Hello "+cbean.getFirstName()+"<br>");
out.println("You have charged Rs."+cost+" <br>");
out.println("Your order placed successfully");

%>

<a href="view2">View Product</a><br>
<a href="customerlogout">LogOut</a>

</h1>

</body>
</html>