<%@page import="models.Empleado"%>
<%@page import="repositories.interfaces.EmpleadoRepo"%>
<%@page import="repositories.EmpleadosRepoSingleton"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
EmpleadoRepo repo = EmpleadosRepoSingleton.getInstance();

Empleado emple = repo.findById(2);

request.setAttribute("empleado", emple);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Listar un empleado</title>
</head>
<body>
	<h1>Empleado</h1>
	<p>Nombre: <c:out value="${empleado.nombre}" /></p>
	<p>Nombre: <c:out value="${empleado.edad}" /></p>
	<p>Nombre: <c:out value="${empleado.sueldo}" /></p>
	
</body>
</html>