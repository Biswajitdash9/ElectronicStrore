<%@page import="com.buyrecord.panel.RecordBean"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<RecordBean> al=(ArrayList<RecordBean>)session.getAttribute("record");

if(al==null)
{
	out.println("You do not have purchased yet"+"<br>");
}
else
{
	out.println("Your Order history"+"<br>");
	
	for(RecordBean rb:al)
	{
		out.println(rb.getOrderid()+" "+rb.getPname()+" "+rb.getPcompany()+" "+rb.getPrice()+" "+rb.getItemPurchased()+" "+rb.getTotal()
		+" "+rb.getDate()+"<br><br>");
	}
}

%>
<a href="CustomerHome.jsp">Back</a>
</h1>
</body>
</html>