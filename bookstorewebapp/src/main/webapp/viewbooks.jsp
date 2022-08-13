<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>
</head>
<body>

	<h1>Book List</h1>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>ISBN</th>
			<th>Price</th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.isbn}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="bookstore.html">Home</a>
</body>
</html>