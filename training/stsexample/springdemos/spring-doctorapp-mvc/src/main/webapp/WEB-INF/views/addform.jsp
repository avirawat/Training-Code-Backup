<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addDoctorController">
Enter Doctor ID<input type="text" name="doctorId" required><br>
Enter Doctor Name<input type="text" name="doctorName" required><br>
Enter City <input type="text" name="city" required><br>
Enter Doctor Specialisation<input type="text" name="specialisation" required><br>
Enter Hands On Experience<input type="text" name="experience" required><br>
Enter Consultancy Fee<input type="text" name="fee" required><br>
<input type="submit" value="Add Doctor">
</form>
</body>
</html>