<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Home Page</h1>
<div>
	<a href="admin">Admin</a>
</div>
<form action="search">
	Search By Speciality<input type="text" name="searchName">
	<input type="submit" value="submit">
	
</form>
<form action="searchFee">
	Search By Fee<input type="text" name="choice">
	<input type="submit" value="submit">
	
</form>
${doctorList}
${doctorListFee}
</body>
</html>