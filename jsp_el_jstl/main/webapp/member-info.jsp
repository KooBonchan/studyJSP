<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<tr>
			<td>${id }</td>
			<td>${password }</td>
			<td>${name }</td>
			<td>${email }</td>
			<td>${address }</td>
		</tr>
	</table>
</body>
</html>