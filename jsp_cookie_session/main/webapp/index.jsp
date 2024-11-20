<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String key = (String) session.getAttribute("token"); %>
<% if (key != null) { %>
	Hello, <%= key %>
<% } else {
	response.sendRedirect("/login.html");
	// use filter instead.
} %>
<% session.invalidate(); %>
</body>
</html>