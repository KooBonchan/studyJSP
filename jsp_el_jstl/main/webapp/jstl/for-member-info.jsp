<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="id"        value="hong" scope="page" />
<c:set var="password"  value="1234" scope="page" />
<c:set var="name"      value="${'홍길동'}" scope="page" />
<c:set var="age"       value="${22}" scope="page" />
<c:set var="height"    value="${174}" scope="page" />
<%
	List<String> data = new ArrayList<>();
	data.add("hello");
	data.add("world");
	data.add("유티에프8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Info</title>
<style>
table {
	border-collapse: collapse;
}
thead td{
	background-color: #ccc;
	font-weight:bold;
	font-size:20px;
	text-align:center;
}
td{
	border: 1px solid #ccc;
	padding: 0 3px;
}
</style>
</head>
<body>
	<table style="border-collapse: collapse;">
		<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
			<tr>
				<td>i = ${i }</td>
				<td>loopcount = ${loop.count }</td>
			</tr>
		</c:forEach>
		<tr><td colspan=2 style="background-color:#ccc; border: 1px solid #ccc;">step = 2</td></tr>
		<c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
			<tr>
				<td>i = ${i }</td>
				<td>loopcount = ${loop.count }</td>
			</tr>
		</c:forEach>
		<tr><td colspan=2 style="background-color:#ccc; border: 1px solid #ccc;">list</td></tr>
		<c:forEach var="datum" items="<%=data %>" varStatus="loop">
			<tr>
				<td>${datum}</td>
				<td>loopcount = ${loop.count }</td>
			</tr>
		</c:forEach>
		<tr><td colspan=2 style="background-color:#ccc; border: 1px solid #ccc;">String split</td></tr>
		<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
		<c:forTokens var="fruit" items="${fruits}" delims=",">
			<tr>
				<td>${fruit}</td>
			</tr>
		</c:forTokens>
	</table>
	
	<table>
		<thead>
			<tr>
				<td>index</td>
				<td>ID</td>
				<td>Password</td>
				<td>Name</td>
				<td>Email</td>
				<td>Address</td>
			</tr>
		</thead>
		<c:forEach var="member" items="${members}" varStatus="loop">
			<tr>
				<td>${loop.count}</td>
				<td>${member.id}</td>
				<td>${member.password}</td>
				<td>${member.name }</td>
				<td>${member.email }</td>
				<td>${member.address }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>