<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${doctor}
<h1>Update Doctor form</h1>
<form action="updateDoctorController">
	Enter Doctor ID<input type="text" name="doctorId" value="${doctor.doctorId}"><br>
	Enter Doctor Name<input type="text" name="doctorName" value="${doctor.doctorName}"><br>
	Enter City <input type="text" name="city" value="${doctor.city}"><br>
	Enter Doctor Specialisation<input type="text" name="specialisation" value="${doctor.specialisation}"><br>
	Enter Hands On Experience<input type="text" name="experience" value="${doctor.experience}"><br>
	Enter fee<input type="text" name="fee" value="${doctor.fee}"><br>
	<input type="submit" value="Update Doctor">
</form>
</body>
</html>