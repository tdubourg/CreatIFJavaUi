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
		<title>Gestion des galeries</title>
		<script type="text/javascript" >
			function toggleRowSelection (tr, box) {
				tr.classList.toggle("selected");
				id = tr.getAttribute("id").replace("tr_", "");
				if(console && console.log) {
					console.log("Id :" + id);
					console.log(box);
					console.log(box.checked);
					console.log(box.disabled);
				}
				//$("#right_col .col_content").html($("#right_col .col_content").html() + $(tr).find(".oeuvre_name").eq(0).html());
				if(!box.checked) {//* On est en train de décocher
					var todelete = $("#right_col .col_content #panier_"+id).get(0);
					todelete.parentNode.removeChild(todelete);
										//* MàJ du prix :
					prix = Math.abs($(tr).find(".oeuvre_prix").eq(0).html().replace("€", ""));
					currTotal = Math.abs($("#total_price").html().replace("€", ""));
					currTotal -= prix;
					$("#total_price").html(currTotal + " €");

				} else {//* On est en train de cocher
					var p = document.createElement("p");
					p.setAttribute("ID", "panier_"+id);
					p.innerHTML = $(tr).find(".oeuvre_name").eq(0).html();
					$("#right_col .col_content").get(0).appendChild(p);
					//* MàJ du prix :
					prix = Math.abs($(tr).find(".oeuvre_prix").eq(0).html().replace("€", ""));
					currTotal = Math.abs($("#total_price").html().replace("€", ""));
					currTotal += prix;
					$("#total_price").html(currTotal + " €");
				}
				return ;
				
			}
		</script>
		<style type="text/css" >
			
			/*#global_submit_button {
				position: absolute;
				bottom: 0px;
				left: 33%;
			}*/
			
			#global_submit_button {
				text-align:center;
			}

			div, *, body, html, p {
				padding:0;
				magin:0;
				/*border: 1px solid pink;*/
			}
			.selected {
				background-color: lightblue;
			}
			#left_col {
				float:left;
				height:99%;
			}

			#right_col {
				float:right;
				height:99%;
			}

			#left_col, #right_col {
				width: 18%;
				height:99%;
			}

			.col_title {
				height: 2em;
				font-weight: bold;
				text-align:center;
				line-height: 2em;
			}

			.col_content, .col_title, #account, #dates {
				width:100%;
				border: 2px solid black;
				margin-bottom: 5px;
			}

			.col_content {
				height: 91%;
				overflow-y: auto;
			}
			
			#right_col .col_content {
				height: 78%;
				position:relative;
			}
			#center_col {
				margin-left: 20%;
				width : 58%;
				padding-left: 1%;
				padding-right: 1%;
				height:100%;
			}
			body {
				height: 99%;
				position:absolute;
				width: 98%;
			}
			#account, #dates {
				height: 49%;
				text-align:center;
				margin-bottom: 5px;
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
		<div id="right_col" >
			<div class="col_title" >
				Votre galerie
			</div>
			<div class="col_content" >
				
			</div>
			<div class="col_title" >
				Prix :<span id="total_price" style="display:inline-block; width: 70%; text-align: right;" >0 &euro;</span>
			</div>
			<div class="col_title" >
				<input id="global_submit_button" type="button" onclick="$('#selection_form').get(0).submit();" value="Envoyer" />
			</div>
		</div>
		<div id="left_col" >
			<div id="account" style="text-align:center;" >
				<br />
				<a href="controller?action=help" >Aide</a>
			</div>
			<div id="dates" >
				<h4 style="text-align:center" >Nouvelle galerie</h4>
				<input type="text" id="datepicker" name="date" onclick="this.value='';" value="jj/mm/aaaa"/></label><br />
				<input type="text" id="datepicker2" name="date2" onclick="this.value='';" value="jj/mm/aaaa"/></label><br />
				<input type="button" id="submit_dates" value="Valider" />
				<script type="text/javascript" >
					$("#datepicker").datepicker();
					$("#datepicker").datepicker( "option", "dateFormat", "dd/mm/yy");
					
					$("#datepicker2").datepicker();
					$("#datepicker2").datepicker( "option", "dateFormat", "dd/mm/yy");
					$("#submit_dates").bind("click", function () {
						$("#right_col .col_content p").each(function (i, e) {
							e.parentNode.removeChild(e);
						});
						$("#center_col .col_content").load("controller?action=load_catalog&start_date="+$("#datepicker").get(0).value+"&end_date="+$("#datepicker2").get(0).value);
					});
				</script>
			</div>
		</div>
		<div id="center_col" >
			<div class="col_title" >Oeuvres disponibles</div>
			<div class="col_content"></div>

		</div>
	</body>
</html>
