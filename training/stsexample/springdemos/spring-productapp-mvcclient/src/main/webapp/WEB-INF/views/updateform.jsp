<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${product}
<h1>Update Product form</h1>
<form action="updateProduct">
Enter Name<input type="text" name="productName" value="${product.productName}" readonly><br>
Enter category<input type="text" name="category" value="${product.category}"><br>
Enter Price<input type="text" name="price" value="${product.price}"><br>
<input type="hidden" name="productId" value="${product.productId}"><br>
<input type="submit" value="update Product">
</form>
${message}
</body>
</html>