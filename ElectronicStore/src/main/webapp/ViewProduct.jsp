<%@page import="java.util.Iterator"%>
<%@page import="com.product.panel.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
  AdminBean abean=(AdminBean) session.getAttribute("abean");
String msg=(String)request.getAttribute("msg");

if(msg!=null)
{
out.println(msg+"<br>");
}

ArrayList<ProductBean>	al=(ArrayList<ProductBean>)session.getAttribute("productlist");






if(al.size()==0)
{
	out.println("Product are not Available ");
}
else
{
	out.println("<u> Hello "+abean.getAdminFname()+" these are your Product Details"+"</u><br>");
	Iterator<ProductBean> i=al.iterator();
	
	while(i.hasNext())
	{
		ProductBean pb=i.next();
		out.print(" <br>"+pb.getpCode()+" "+pb.getpName()+" "+pb.getpCompany()+" "+pb.getpPrice()+" "+pb.getpQtn()
		+" <a href='edit?pcode="+pb.getpCode()+"'>Edit</a>"
		+" "+"<a href='delete?pcode="+pb.getpCode()+"'>Delete</a><br>");

		
	}
}

%>

</h1>

</body>
</html>