<%-- 
    Document   : index
    Created on : 2 mars 2012, 15:59:42
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Identification</title>
    </head>
    <body>
        <h1 style="margin:auto">Bienvenue chez Creat'IF</h1>
        <form action ="galeries.jsp" method="POST" style="margin:auto">
            <label>Login</label>
            <input type="text" name="login" value="">
            <input type="submit" value="Connexion"> 
        </form>
        <%
           try{
                int id = Integer.parseInt(request.getParameter("login"));
                out.println("<p>id du client : " + id +"</p>");%>
                <jsp:forward page="galeries.jsp"/>
            <%}
            catch(NumberFormatException e){
                out.println("<p>id du client :</p>");%>
                <jsp:forward page="index.jsp"/>
       <%}%>
        
        <p></p>
    </body>
</html>
