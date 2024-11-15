<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="../style/darkmode.css">
<link rel="stylesheet" type="text/css" href="./style/signup.css">
</head>
<body>
	<form method="post" action="signup-confirm.jsp" id="form">
	<table>
		<thead>
			<tr><td colspan=2>Sign Up</td></tr>
		</thead>
		<tbody>
			<tr>
				<td class="label">ID</td>
				<td class="input">
				<input name="id" id="id">
				</td>
			</tr>
			<tr>
				<td class="label">Password</td>
				<td class="input">
				<input type="password" name="password" id="password">
				</td>
			</tr>
			<tr>
				<td class="label">Verify Password</td>
				<td class="input">
				<input type="password" name="verify" id="verify">
				</td>
			</tr>
			<tr>
				<td class="label">Name</td>
				<td class="input">
				<input name="name" id="name">
				</td>
			</tr>
			<tr>
				<td class="label">e-Mail</td>
				<td class="input">
				<input type="email" name="email" id="email">
				</td>
			</tr>
			<tr>
				<td class="label">Birthday</td>
				<td class="input">
				<input type="date" name="birthday" value="2000-01-01" id="birthday">
				</td>
			</tr>
			<tr><td colspan=2><div id="button-bar">
				<a href="#" id="submit">SUBMIT</a>
				<a href="#" id="reset">RESET</a>
			</div></td></tr>
		</tbody>
	</table>
	</form>
<script src="./js/signup.js"></script>
</body>
</html>