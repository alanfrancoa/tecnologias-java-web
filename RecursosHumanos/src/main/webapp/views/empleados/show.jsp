
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Listar un empleado</title>
</head>
<body>
	<h1>Empleado</h1>
	<p>Nombre: <c:out value="${empleado.nombre}" /></p>
	<p>Edad: <c:out value="${empleado.edad}" /></p>
	<p>Sueldo: <c:out value="${empleado.sueldo}" /></p>
	
</body>
</html>