<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Alumnos listado</title>
</head>
<body>
<h1>Lista Alumnos</h1>
<br/>
    <ul id="alumnos">
        <c:forEach var="alumno" items="${alumnos}">
            <li>
                <span>${alumno.id} </span>
                <span>${alumno.nombre}</span>
            </li>
        </c:forEach>
    </ul>
<br />


</body>
</html>
