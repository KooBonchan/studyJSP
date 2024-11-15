<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.company.bean.MemberBean" scope="page" />
<jsp:setProperty name="member" property="*" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Confirm your Data</title>
<link rel="stylesheet" type="text/css" href="../style/darkmode.css">
<link rel="stylesheet" type="text/css" href="./style/signup.css">
<style>
td.label{
	width:80px;
	font-size: 14px;
	font-weight:bold;
}
td.value{
	border-left:1px solid #666;
	font-size:16px;
	line-height:20px;
}

#cancel{
	color:#fff;
}
</style>
</head>
<body>
<form method="post" action="#"> <!--db manage-->
	<table>
		<thead>
			<tr><td colspan=2>Confirm your data</td></tr>
		</thead>
		<tbody>
			<tr>
				<td class="label">ID</td>
				<td class="value"><jsp:getProperty name="member" property="id" /></td>
			</tr>
			<tr>
				<td class="label">Name</td>
				<td class="value"><jsp:getProperty name="member" property="name" /></td>
			</tr>
			<tr>
				<td class="label">e-Mail</td>
				<td class="value"><jsp:getProperty name="member" property="birthday" /></td>
			</tr>
			<tr>
				<td class="label">Birthday</td>
				<td class="value"><jsp:getProperty name="member" property="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><div id="button-bar">
					<a href="#" id="submit">SUBMIT</a>
					<a href="#" id="cancel">CANCEL</a>
				</div></td>
			</tr>
		</tbody>
	</table>
</form>
<script src="./js/signup-confirm.js"></script>
</body>
</html>