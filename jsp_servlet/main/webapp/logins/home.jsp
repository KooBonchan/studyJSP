<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Home</title>
<link rel="stylesheet" type="text/css" href="/studyServlet/style/darkmode.css">
</head>
<body>
<%
if(id == null){
	%>
	<jsp:forward page="logout.jsp"/>
	<%
}
%>
<h1>Welcome, <%=id %></h1>
<a href='logout.jsp'>Logout</a>
</body>
</html>