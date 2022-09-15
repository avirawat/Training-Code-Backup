<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Admin DashBoard</h1>
	<a href="addDoctor"> Add New Doctor</a><br>
	<a href="editDoctor">Edit Doctor details</a><br>
	<a href="deleteDoctor">Delete Doctor Details</a><br>
	<hr>
	<a href="home">Home</a><hr>
	${message}
	${doctorList}
</body>
</html>