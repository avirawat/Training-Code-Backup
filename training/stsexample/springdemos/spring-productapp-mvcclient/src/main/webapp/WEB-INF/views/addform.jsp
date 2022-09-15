<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addProduct">
Enter Product Name<input type="text" name="productName"><br>
Enter category<input type="text" name="category"><br>
Enter Price<input type="text" name="price"><br>
<input type="submit" value="Add Product">
</form>
${message}
</body>
</html>