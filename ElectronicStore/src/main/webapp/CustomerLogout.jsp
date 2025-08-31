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
session.invalidate();
out.println("Logout Successfully");

%>
<jsp:include page="Index.html"></jsp:include>

</h1>

</body>
</html>
