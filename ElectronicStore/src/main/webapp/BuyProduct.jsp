<%@page import="com.product.panel.ProductBean"%>
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
   ProductBean pb =(ProductBean)session.getAttribute("productbean");
%>

<form action="buy1" method="post">

Product Code:<input type="text" value="<%=pb.getpCode()%>" name="pcode" readonly> <br>
Product Name:<input type="text" value="<%=pb.getpName()%>" name="pname" readonly> <br>
Company Name:<input type="text" value="<%=pb.getpCompany()%>" name="pcompany" readonly> <br>
Product Price:<input type="text" value="<%=pb.getpPrice()%>" name="price" readonly> <br>
Product Availability:<input type="text" value="<%=pb.getpQtn()%>" name="avail" readonly> <br>
Quantity:<input type="text" name="quantity" > <br>
<input type="submit" value="BUY" > 

</form>
<a href="view2">Back</a>

<%

String  msg =(String)request.getAttribute("msg");

if(msg!=null)
{
	out.println(msg);
}

%>

</h1>

</body>
</html>