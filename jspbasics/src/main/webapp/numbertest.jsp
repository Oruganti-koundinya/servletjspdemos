<%@ page import="jspbasics.Utils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	Add 5 to 11 = <%= Utils.add5ToNumber(11) %>

	<jsp:include page="footer.jsp" />

</body>
</html>