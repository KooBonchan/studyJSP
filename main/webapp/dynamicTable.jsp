<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dynamic Table</title>
<style>
*{
	margin: 0 auto;
	padding: 0;
}
table{
	margin-top:30px;
	border-collapse:collapse;
}
table tr td {
	border: 1px solid #ccc;
}
</style>
</head>
<body>
<%!
	String[] techStack = {"Haskell", "Python", "Java"};
%>

<table>
<%
	for(int i = 0; i < techStack.length; i++){

%>
<tr>
<td class="index"> <%=i+1 %></td>
<td class="content"> <%=techStack[i] %></td>
</tr>
<%
	}
%>
</table>

</body>
</html>