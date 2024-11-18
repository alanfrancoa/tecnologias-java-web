
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleados</title>
</head>
<body>

	<a href="empleados?accion=create" >Agregue un empleado</a>
	
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
					<td> <a href="empleados?accion=show&id=${empleado.id}">Ver</a> </td>
					<td> <a href="empleados?accion=edit&id=${empleado.id}">Editar</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>