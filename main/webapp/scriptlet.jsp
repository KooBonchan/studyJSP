<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet Test</title>
</head>
<body>
<%!
	Random random = new Random();
	String declaration = "Declaration";
	public String getDeclaration(){ return declaration; }
%>
<%
	String scriptlet = "Scriptlet";
	String comment = "Comment";
	out.println("OUT by servlet out: " + scriptlet + "<p/>");
%>

Declaration: <%=getDeclaration() %> <p/>
Scriptlet: <%=scriptlet %>
</body>
</html>