<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String[] cities = {"Hyderbad","Pune","Chennai"};
	pageContext.setAttribute("mycities",cities);
	%>
	<c:forEach var="city" items="${mycities}">
		${city} <br/>
	</c:forEach>
</body>
</html>