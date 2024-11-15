<%@page import="lombok.Setter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lombok.Getter"%>
<%@page import="lombok.AllArgsConstructor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
private static class UserFull{
	private String id, name, email, phone, zipcode, address, job;
	private byte[] passwordHash;
	
}
String fromHash(byte[] hashed){
	StringBuilder stringBuilder = new StringBuilder();
	int maxIter = Math.min(hashed.length, 5);
	for(int i = 0; i < maxIter; i++){
		stringBuilder.append(String.format("%02x",hashed[i]));
	}
	return stringBuilder.toString();
}
%>
<%
	String sql = "select * from user_full";
	List<UserFull> users = new ArrayList<>();
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_board", "kbc", "12345");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
		){
			if(resultSet == null) return;
			while(resultSet.next()){
				UserFull user = new UserFull();
				user.id=resultSet.getString("id");
				user.passwordHash=resultSet.getBytes("password_hash");
				user.email=resultSet.getString("email");
				user.name=resultSet.getString("name");
				user.phone=resultSet.getString("phone");
				user.zipcode=resultSet.getString("zipcode");
				user.address=resultSet.getString("address");
				user.job=resultSet.getString("job");
				users.add(user);
			}
		}
	} catch(Exception e){
		System.out.println("Developer error occurred");
	}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST DB CONNECTION</title>
<style>
table {
border-collapse: collapse;
}
table td{
border: 1px solid #999;
}
tbody td{
}
</style>
</head>
<body>
<h2>JSP Simple Connection test</h2>
<table>
<thead>
	<tr>
	<td><strong>ID</strong></td>
	<td><strong>password</strong></td>
	<td><strong>name</strong></td>
	<td><strong>e-mail</strong></td>
	<td><strong>Phone number</strong></td>
	<td><strong>zip code</strong></td>
	<td><strong>address</strong></td>
	<td><strong>job</strong></td>
	</tr>
</thead>
<tbody>
<%
for(var user: users){
	%>
	<tr>
	<td><%=user.id %></td>
	<td><%=fromHash(user.passwordHash) %></td>
	<td><%=user.name%></td>
	<td><%=user.email%></td>
	<td><%=user.phone%></td>
	<td><%=user.zipcode%></td>
	<td><%=user.address%></td>
	<td><%=user.job%></td>
	</tr>
	<%
}
%>
</tbody>
</table>


</body>
</html>