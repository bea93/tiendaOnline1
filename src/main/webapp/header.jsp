<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, dao.RolesDao, entities.Roles, servlet.Login" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div><b>Usuario:</b> <%=session.getAttribute("nombre")%> <b>Fecha login:</b> <%=session.getAttribute("fecha") %></div>
	<div>
		<input type=<%= (request.getRequestURI().endsWith("menu.jsp")) ? "hidden":"button" %> value="Volver" onClick="history.go(-1);">
		<form id="Logout" action="Logout" method="post">
			<input type="submit" value="Log out" id="button-logout" />
		</form>
	</div>
</body>
</html>