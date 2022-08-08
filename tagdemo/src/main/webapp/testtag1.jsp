<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var = "mytime" value ="<%= new java.util.Date() %>" />
	
	Time on Server = ${mytime}
</body>
</html>