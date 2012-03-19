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
		<script type="text/javascript" >
			function toggleRowSelection (tr) {
				tr.classList.toggle("selected");
				return ;
				
			}
		</script>
		<style type="text/css" >
			.selected {
				background-color: lightblue;
			}
			#left_col {
				float:left;
			}

			#right_col {
				float:right;
			}

			#left_col, #right_col {
				width: 18%;
			}

			#center_col {
				border-left: 2px solid black;
				border-right: 2px solid black;
				margin-left: 20%;
				width : 58%;
				padding-left: 1%;
				padding-right: 1%;
				height:100%;
				overflow: scroll;
			}
			body {
				height: 100%;
			}
		</style>
		<script type="text/javascript">
			<%@ include file="js/jquery.min.js" %>
		</script>
		<script type="text/javascript">
			<%@ include file="js/jquery-ui-datepicker/js/jquery-ui-1.8.15.custom.min.js" %>
		</script>
		<script type="text/javascript">
			<%@ include file="js/jquery-ui-datepicker/js/jquery.ui.datepicker.min.js" %>
		</script>

		<script type="text/javascript">
			<%@ include file="js/jquery-ui-datepicker/js/jquery.ui.datepicker-fr.js" %>
		</script>

		<style type="text/css">
			<%@ include file="js/jquery-ui-datepicker/css/ui-lightness/jquery-ui-1.8.15.custom.css" %>
		</style>

	</head>
	<body>
		<div id="right_col" >aaa</div>
		<div id="left_col" >
			<div id="account" >

			</div>
			<div id="dates" >
				<input type="text" id="datepicker" name="date" onclick="this.value='';" value="jj/mm/aaaa"/></label><br />
				<script type="text/javascript" >
					$("#datepicker").datepicker();
					$("#datepicker").datepicker( "option", "dateFormat", "dd/mm/yy");
				</script>
			</div>
		</div>
		<div id="center_col" >

		</div>
	</body>
</html>
