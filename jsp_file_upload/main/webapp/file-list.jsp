<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
	padding: 0;
	list-style: none;
}
a {
	text-decoration: none;
	color: inherit;
}
table {
	border-collapse: collapse;
}
table tr td {
	border: 1px dashed #999;
}
thead tr td{
	border: none;
	background-color: #666;
}
</style>
</head>
<body>

<h2>File board</h2>
<table>
<thead>
<tr>
<td>Index</td>
<td>Title</td>
<td>Filename</td>
<td>image</td>
<td>Post date</td>
<td>Download</td>
</tr>
</thead>
<c:forEach var="file" items="${files }">
<tr>
	<td>${file.idx }</td>
	<td>${file.title }</td>
	<td>${file.original }</td>
	<td>
	<img src="uploads/${file.saved}" alt="${file.saved}"></td>
	<td>${file.postdate}</td>
	<td><a href="file-download?idx=${file.idx}">[Download]</a></td>
</tr>
</c:forEach>

</table>
<a href="file-upload.jsp">Upload File</a><br>
<a href="multi-upload.jsp">Upload Multiple Files</a><br>
</body>
</html>