<%@page import="models.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="repositories.interfaces.EmpleadoRepo"%>
<%@page import="repositories.EmpleadosRepoSingleton"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	EmpleadoRepo repo = EmpleadosRepoSingleton.getInstance();
	List<Empleado> listaEmple = repo.getAll();
	
	request.setAttribute("listita", listaEmple);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleados</title>
</head>
<body>
	
	<table border="1">
		<thead>
			<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Sueldo</th>
			<th></th>
			<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="empleado" items="${listita}">
				<tr>
					<td> <c:out value="${empleado.id }"/> </td>
					<td> <c:out value="${empleado.nombre}"/> </td>
					<td> <c:out value="${empleado.edad}"/> </td>
					<td> <c:out value="${empleado.sueldo}"/> </td>
					<td> <a href="#">Ver</a> </td>
					<td> <a href="#">Editar</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>