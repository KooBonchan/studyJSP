<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formatting Tags</title>
</head>
<body>
	<h2>Use &lt;fmt:formatNumber&gt; for formatting number</h2>
	<c:set var="price" value="1234.56789" />
	<fmt:formatNumber value="${price}" type="number" />
	<br>
	<fmt:formatNumber value="${price }" type="currency" currencySymbol="￦"
		groupingUsed="true" maxFractionDigits="0" />
	<br>
	<fmt:formatNumber value="${price }" type="percent" groupingUsed="false"
		maxFractionDigits="3"></fmt:formatNumber>
	<br>
	<p />

	<h2>Use &lt;fmt:formatDate&gt; for formatting date</h2>
	<c:set var="now" value="<%=new Date()%>" />
	<fmt:formatDate value="${now }" type="date" dateStyle="full" />
	<br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short" />
	<br>
	<fmt:formatDate value="${now }" type="time" />
	<br>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	<br>
	<fmt:formatDate value="${now }" pattern="YYYYMMdd hh:mm:ss" /> <br />
	<p /><br />
	<p /><br />
	Korea: <fmt:formatDate value="${now }" pattern="YYYYMMdd hh:mm:ss" /> <br />
	<fmt:timeZone value="America/New York">
	New York: <fmt:formatDate value="${now }" pattern="YYYYMMdd hh:mm:ss" /> <br />
	</fmt:timeZone>
	
	

</body>
</html>