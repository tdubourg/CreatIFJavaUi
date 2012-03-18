<%-- 
    Document   : checkout
    Created on : Mar 18, 2012, 12:30:32 AM
    Author     : troll
--%>

<%@page import="service.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		Vous avez demandé la réservation des oeuvres :
		<ul>
			<% for (String s : request.getParameterValues("ids[]")) {
			%>
			<li>
				<% out.print(Service.rechercherOeuvreParNumId(Integer.parseInt(s)).getNom());%>
			</li>
			<%
				}
			%>
		</ul>
	</body>
</html>
