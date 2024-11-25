<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="id"        value="hong" scope="page" />
<c:set var="password"  value="1234" scope="page" />
<c:set var="name"      value="${'홍길동'}" scope="page" />
<c:set var="age"       value="${22}" scope="page" />
<c:set var="height"    value="${174}" scope="page" />
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
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Password</td>
				<td>Name</td>
				<td>Email</td>
				<td>Address</td>
			</tr>
		</thead>
		<c:remove var="name" />
		<c:choose>
			<c:when test="${empty name}">
			<tr>
				<td colspan=5 style="text-align:center;">No member name</td>
			</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>${id }</td>
					<td>${password }</td>
					<td>${name }</td>
					<td>${age }</td>
					<td>${height}</td>
				</tr>
			</c:otherwise>
		</c:choose>

	</table>

	
	<c:if test="${true}">
		<h1>Always True</h1>
	</c:if>
	<c:if test="${11==11}">
		<h1>Always True</h1>
	</c:if>
	<c:if test="${11==31}">
		<h1>Always false</h1>
	</c:if>
	<c:if test="${(id=='hong') && (name=='홍길동')}">
		<h1>My name is Hong Gildong: Sometimes True</h1>
	</c:if>
	<c:if test="${height > 160}">
		<h1>over 160</h1>
	</c:if>
</body>
</html>