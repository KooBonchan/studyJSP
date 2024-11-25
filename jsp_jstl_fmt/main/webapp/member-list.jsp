<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Members</title>
<style>
table{
	border-collapse: collapse;
}

.member-header td{
	background-color: #333;
	color: #ccc;
	font-weight: 900;
	
}

.member-binder td{
	border: 1px solid #ccc;
}
</style>
</head>
<body>

<c:choose>
<c:when test="${empty members}">
</c:when>
<c:otherwise>
<table>
<thead>
<tr class="member-header">
	<td>ID</td>
	<td>Password</td>
	<td>Name</td>
	<td>e-Mail</td>
	<td>Join Date</td>
</tr>
</thead>

<c:forEach var="member" items="${members}">
	<tr class="member-binder">		
		<td>${member.id}</td>
		<td>${member.password}</td>
		<td>${member.name}</td>
		<td>${member.email}</td>
		<td>
		<fmt:formatDate value="${member.joinDate}" pattern="YYYY년 MM월 dd일"/>
		</td>
	</tr>
</c:forEach>
</table>
<a href="signup.html">ADD NEW MEMBER</a>
</c:otherwise>
</c:choose>

</body>
</html>