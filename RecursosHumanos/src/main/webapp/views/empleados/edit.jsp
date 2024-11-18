
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>
	<h1>Editar</h1>
	
	<form action="empleados" method="post">
	<input type="hidden" value="update" name="accion"/>
		<p>ID: <input value="${empleado.id}" name="id"/></p>
		<p>Nombre: <input value="${empleado.nombre}" name="nombre"/></p>
		<p>Edad: <input value="${empleado.edad}" name="edad"/></p>
		<p>Sueldo: <input value="${empleado.sueldo}" name="sueldo"/></p>
		<input type="submit" value="Editar"/>
	</form>

</body>
</html>