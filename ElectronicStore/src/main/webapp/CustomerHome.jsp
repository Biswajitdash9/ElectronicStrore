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

out.println("Welcome  Mr."+cbean.getFirstName()+"<br>");


%>

<a href="view2">View Product</a><br>
<a href="view3">My Order</a><br>

<a href="customerlogout">LogOut</a>

</h1>

</body>
</html>