<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	The student registration is confirmed: ${param.firstname} ${param.lastname}
	<br/>
	Welcome <%= request.getParameter("firstname") %> <%= request.getParameter("lastname") %>
	<p>You are from ${param.country}</p>
	Your favourite programming languages are: 
	<ul>
		<%
			String[] langs = request.getParameterValues("favouriteLanguage");
			for (String lang : langs) {
				out.println("<li>" + lang + "</li>");
			}
		%>
	
	</ul>
</body>
</html>