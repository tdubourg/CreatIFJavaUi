<%@ page import="java.util.*" %>
<%@ page import="service.Service" %>
<%@ page import="modele.*" %>
<form action="./controller?action=submit_gallery" method="post" id="selection_form" name="selection_form" />
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
	<% List<Oeuvre> list = (List<Oeuvre>) request.getSession(true).getAttribute("oeuvreList");
		if (list == null) {
			out.println("Aucune date.");
		} else {
			for (Oeuvre o : list) {
	%>
	<tr class="pouet" id="tr_<% out.print(o.getIdOeuvre());%>">
		<td class="oeuvre_name">
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
			<input onclick="toggleRowSelection(this.parentNode.parentNode, this);" type="checkbox" name="ids[]" value="<%
				out.print(o.getIdOeuvre());
			       %>" />
		</td>
	</tr>
	<%
			}
		}


	%>
</table>
</form>