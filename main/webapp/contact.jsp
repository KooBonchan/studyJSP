<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>정보나눔</title>
</head>
<body>
<%
String name = request.getParameter("name");
String email = request.getParameter("email");
String message = request.getParameter("message");
%>


<table>
<tr>
    <td>이름</td>
    <td><%=name %></td>
</tr>
<tr>
    <td>이메일</td>
    <td><%=email %></td>
</tr>
<tr>
    <td>보내신 말씀</td>
    <td style="width:250px;"><%=message %></td>
</tr>       
<tr>
    <td><input type="submit"></td>
</tr>        
</table>    
</body>
</html>