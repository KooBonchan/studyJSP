<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String name = request.getParameter("name");
	String color = request.getParameter("color");
	String message;
	switch(color){
	case "blue":
	case "green":
	case "red":
	case "gray":
		message = color;
		break;
	default:
		message = "Other color";
	}
%>
<meta charset="UTF-8">
<title>Conditional</title>

<style>
body {
	background-color: <%=color%>;
};
</style>
</head>
<body>
<h1>If Else Example</h1>
<b><%=name %></b>'s favorite color is <%=message %>.
</body>
</html>