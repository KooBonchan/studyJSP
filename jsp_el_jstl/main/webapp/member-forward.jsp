<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("id", "garcia");
	request.setAttribute("password", "aprieta");
	request.setAttribute("name", "Vincen Garcia");
	request.setAttribute("email", "vincen@cory.wang");
	request.setAttribute("address", "Yentong, Suwon");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<jsp:forward page="member-info.jsp" />
</body>
</html>