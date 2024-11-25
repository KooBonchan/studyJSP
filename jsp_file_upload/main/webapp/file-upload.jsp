<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

ul li {
	width: 400px;
	margin:0;
}
</style>
</head>
<body>

<h2>Upload your file, mainly image</h2>
<span style="color:red;">${errorMessage}</span>
<form name="form-file" method="post" enctype="multipart/form-data"
	action="file" onsubmit="return validate(this);">
	<ul>
	<li><input type="text" name="title" placeholder="Title"/></li>
	<li>
		<label for="file">File: </label>
		<input type="file" name="file" />
	</li>
	<li><input type="submit" value="SUBMIT" /></li>
	
	</ul>
	
	
</form>
</body>
<script>
function validate(form){
	if(form.title.value == ""){
		alert("No Title")
		form.title.focus();
		return false;
	}
	if(form.file.value == ""){
		alert("No Attached File")		
		return false;
	}
	return true;
}
</script>
</html>