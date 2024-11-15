<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/studyServlet/style/darkmode.css">
</head>
<body>
<h1>Servlet Logins</h1>
<form method="post" action="/studyServlet/login-try">
	<table>
		<tr>
			<td>ID</td>
			<td><input name="id"></td>
		</tr>
		<tr>
			<td>pwd</td>
			<td><input type="password" name="password"></td>
		</tr>
	</table>
	<input type="submit" value="submit">
</form>
</body>
</html>