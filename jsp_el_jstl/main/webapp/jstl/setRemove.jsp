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
				<td>Age</td>
				<td>Height</td>
			</tr>
		</thead>
		
		<c:remove var="age" />
		<c:remove var="password" />
		<tr>
			<td>${id }</td>
			<td>${password }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height}</td>
		</tr>
	</table>
</body>
</html>