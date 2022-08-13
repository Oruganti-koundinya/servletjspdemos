<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output</title>
</head>
<body>
<%
        if (session.getAttribute("pid") == null ||
            session.getAttribute("pname") == null ||
            session.getAttribute("pprice") == null) {
                response.sendRedirect("error.jsp");
        }
%>
<b>Result</b><br>
<b>Product Id = </b>   <%= session.getAttribute("pid") %><br>
<b>Product Name = </b> <%= session.getAttribute("pname") %><br>
<b>Product Price = </b> <%= session.getAttribute("pprice") %><br>
<a href="logout.jsp">Click here to logout</a>
</body>
</html>
