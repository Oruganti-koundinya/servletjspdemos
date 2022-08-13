<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Web App</title>
</head>
<body>
<% 
		String pid = request.getParameter("p_id");
		String pname = request.getParameter("p_name");
		String pprice = request.getParameter("p_price");
		
		
		if((pid == null || pid.equals("")) || (pname == null || pname.equals("")) || (pprice == null || pprice.equals("")))
				{
					response.sendRedirect("error.jsp");
				}else {
					session.setAttribute("pid", pid);
					session.setAttribute("pname", pname);
					session.setAttribute("pprice", pprice);
					response.sendRedirect("out.jsp");
				}
%>
</body>
</html>