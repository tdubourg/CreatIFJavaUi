<%-- 
    Document   : login
    Created on : Mar 12, 2012, 3:06:47 PM
    Author     : troll
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Identification recquise</title>
	</head>
	<style type="text/css" >
		.warning_box {
			display:block; /* Pour pouvoir être utilisé avec des span */
			background:#ff8181;
			border:1px solid #cf0000;
			border-top:2px solid #cf0000;
			border-bottom:2px solid #cf0000;
			text-align:justify;
			font-weight:bold;
			color:#cf0000;
			margin:1em;
			padding:1em;
		}
	</style>
	<body style="text-align: center;">
		<h1>Veuillez vous identifier</h1>
		<form action="controller" method="post" >
			<input type="hidden" name="action" value="login" />
			Numéro de client : 
			<input type="text" name="numClient" value="" />
			<input type="submit" value="Ok" />
		</form>
		<%
			if (request.getParameter("msg") != null && "err".contains(request.getParameter("msg"))) {
		%>
		<div class="warning_box" >
			Erreur, identifiant invalide.
		</div>
		<%				}
		%>
	</body>
</html>
