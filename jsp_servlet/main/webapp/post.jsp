<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Servlet</title>
<link rel="stylesheet" type="text/css" href="/studyServlet/style/darkmode.css">
</head>
<body>
	<h1>Post Servlet</h1>
	<form action="post-servlet" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td>pwd</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="email"name="email"autocomplete="email"></td>
			</tr>
		</table>
		<input type="submit" value="submit">
	</form>
</body>
</html>