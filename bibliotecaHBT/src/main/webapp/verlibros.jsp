<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
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
		
	}
	
	.table{
		width: 50%;
		margin:auto;
		border-radius:20px;	
	}
	#botones{
		margin-left:40%;
	}
	.btn{
		color:white;
		
	}
	.btn>a{
		color:white;
	}
</style>
<script src="jquery.js"></script>
<script>
	$(document).ready(function() {
	    $('#addLibro').hide();
	    $("#b_form").click(function(){
	        $('#addLibro').slideDown();
	    });
	    
	});
	
</script>
</head>
<body>
	<table class="table table-striped table-dark">
		<tr >
			<th>Título</th>
			<th>Género</th>
			<th>Estado</th>
			<th></th>
		</tr>
		<%
		out.print(metodosBiblioteca.pintarTabla());
		%>
		
	</table>
	<div id="botones">
		<button class="btn btn-secondary"><a href="MiServlet?otra=holi">Añadir Libro otra pag</a></button>
		<button id="b_form" class="btn btn-info">Añadir libro</button>
	</div>
	<div id="addLibro">
		<form action="MiServlet?accion=addlibros" id="formmarca" method="POST" class="form-group">
			<label>Título</label>
			<input type="text" name="ntitulo">
			<label>Género</label>
			<input type="text" name="ngenero">
			<input type="submit">
		</form>
	</div>
</body>
</html>