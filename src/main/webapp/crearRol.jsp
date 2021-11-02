<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="login">
		<h1>Crear rol</h1>
	    <form method="post" action="CrearRol">
			<label for="nombreRol">Nombre del rol:</label>
	        <input type="text" name="nombreRol"required="required" />
	        <button type="submit" class="btn btn-primary btn-block btn-large">Crear rol</button>
	    </form>
	</div>
</body>
</html>