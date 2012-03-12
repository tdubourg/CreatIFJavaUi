<%-- 
    Document   : galleries
    Created on : Mar 12, 2012, 3:34:31 PM
    Author     : troll
--%>
<%@ page import="java.util.*" %>
<%@ page import="service.Service" %>
<%@ page import="modele.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<table>
		<% List<Oeuvre> list = Service.rechercherToutesLesPeintures();
			list.addAll(Service.rechercherToutesLesSculptures());
			
			for(Oeuvre o: list) {
				%>
	<tr>
		<td>
		<%
				out.println(o);
		%>
		</td>
	</tr>
	<%
			}
			
	
	%>
	</table>
	</body>
</html>
