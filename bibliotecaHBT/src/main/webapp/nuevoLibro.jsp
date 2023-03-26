<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="bibliotecaHBT.grabaDatos"%>
<%@page import="bibliotecaHBT.Libro"%>
<%@page import="bibliotecaHBT.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<title>Insert title here</title>
<style>
	a{
		text-decoration:none;
		color:white;
	}
	
	body{
		text-align:center;
	}
	table{
		margin:auto;
		
	}
	
	form{
		width: 40%;
		margin:auto;
	}
</style>
<script src="jquery.js"></script>
<script>
		$(document).ready(function() {
		    $('#otrodiv').hide();
		    
		    $("#genero").change(function(){
			   	var otro = $('#genero').val();
			   	if(otro=="0"){
			   		$('#otrodiv').slideDown();
			   	}else{
			   		$('#otrodiv').slideUp();
			   	}
		    });
		});
</script>
</head>
<body>
	<div id="addLibro">
		<h2>Añadir nuevo libro</h2>
		<form method="POST" id="formmarca" class="form-group">
			<table class="table table-light table-striped">
				<tr>
					<td><label>Título</label></td>
					<td><input type="text" name="n2titulo"></td>
				</tr>
				<tr>
					<td><label>Género</label></td>
					<td><select name="n2genero" id="genero" onchange="mostrar()">
							<%
							List<Genero> generos = (List<Genero>) request.getAttribute("listag");
							out.print(metodosBiblioteca.pintarGeneros(generos));
							%>
							<option value="0" id="otro">Otro</option>
							<option selected disabled>-- Elige un género --</option>
					</select></td>
				</tr>
				<tr id="otrodiv">
					<td><label>Otro</label></td>
					<td><input type="text" name="ngen" id="otro"></td>
				</tr>

			</table>
			<button class="btn btn-dark">Enviar<input type="hidden" name="accion" value="add2libros"></button>
		</form>
		<button class="btn btn-secondary">
			<a href="MiServlet?otra=atras"><< Atrás</a>
		</button>
	</div>
</body>
</html>