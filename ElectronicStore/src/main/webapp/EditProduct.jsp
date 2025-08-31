<%@page import="com.product.panel.ProductBean"%>
<%@page import="com.admin.panel.AdminBean"%>
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
  AdminBean abean=(  AdminBean )session.getAttribute("abean");

ProductBean pbean=(ProductBean )session.getAttribute("pbean");

out.println("Hello "+abean.getAdminFname()+" Please Edit ");


%>

<form action="update" method="post">

Product Price <input type="text" value="<%= pbean.getpPrice()%>" name="pprice" ><br><br>
Product Quantity<input type="text" name="pqty" value="<%= pbean.getpQtn()%>"><br><br>

<input type="hidden" name="pcode" value="<%= pbean.getpCode()%>">
<input type="submit"  value="Update">


</form>

</h1>
</body>
</html>