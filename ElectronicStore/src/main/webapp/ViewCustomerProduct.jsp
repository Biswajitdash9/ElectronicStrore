<%@page import="java.util.Iterator"%>
<%@page import="com.product.panel.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("allproduct");



if(al==null)
{
	out.println("There is no product available ");
}
else
{
	out.println("Hello "+cbean.getFirstName()+". Here is your product list"+"<br>");
Iterator<ProductBean>i=al.iterator();

		while(i.hasNext())
		{
			ProductBean pb=i.next();
			out.println(" <br>"+pb.getpCode()+pb.getpName()+" "+pb.getpCompany()+" "+pb.getpPrice()+" "+pb.getpQtn()+
					" "+" <a href='buy?pcode="+pb.getpCode()+"'>Buy</a><br>");
			
		}
	
}

%>
<a href="CustomerHome.jsp" >Back to menu</a>

</h1>

</body>
</html>