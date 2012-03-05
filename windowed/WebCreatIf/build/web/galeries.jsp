<%-- 
    Document   : galeries.jsp
    Created on : 2 mars 2012, 17:36:48
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vos Galeries</title>
    </head>
    <body>
        <a href="index.jsp">Deconnexion</a>
        <%
          out.println("<p>id du client : " + request.getParameter("login") +"</p>");
        %>
    </body>
</html>
