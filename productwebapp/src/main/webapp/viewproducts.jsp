<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View products</title>
</head>
<body>
	<h1>Product List</h1>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var = "product" items = "${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href = "productdetails.html">HOME</a>
</body>
</html>