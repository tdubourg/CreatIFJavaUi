<%-- 
    Document   : index
    Created on : Mar 5, 2012, 4:25:30 PM
    Author     : troll
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index Page</title>
	</head>
	<body>
		<h1>Hello World!</h1>
		<% 
		Enumeration e = getServletContext().getAttributeNames();
while(e.hasMoreElements()) {
	out.println(e.nextElement()); 
	out.println("<br />");
}
%>
		<form action="index.jsp" method="post" >
			<input type="text" name="login" value="Put your Name Here!" />
			<input type="submit" value="Pouet" />
		</form>
		
		
	</body>
</html>
