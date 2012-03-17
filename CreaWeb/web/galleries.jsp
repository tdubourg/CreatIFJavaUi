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
		<form action="./controller?action=submit_gallery" method="post" />
		<table>
			<thead>
				<tr>
					<th>Nom oeuvre</th>
					<th>Nom artiste</th>
					<th>Description</th>
					<th>Prix</th>
					<th>Réserver</th>
				</tr>
			</thead>
			<% List<Oeuvre> list = Service.rechercherToutesLesPeintures();
				list.addAll(Service.rechercherToutesLesSculptures());

				for (Oeuvre o : list) {
			%>
			<tr>
				<td>
					<%
						out.println(o.getNom());
					%>
				</td>

				<td>
					<%
						out.println(o.getArtiste().getNom() + " " + o.getArtiste().getPrenom());
					%>
				</td>
				<td>
					<%
						out.println(o.getDescription());
					%>
				</td>
				<td>
					<%
						out.println(o.getTarifJournalier());
					%> &euro;
				</td>
				<td>
					<input type="checkbox" name="ids[]" value="<%
						out.print(o.getIdOeuvre());
					%>" />
				</td>
			</tr>
			<%
				}


			%>
		</table>
	</form>
</body>
</html>
