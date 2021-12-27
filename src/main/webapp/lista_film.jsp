<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Film</title>
</head>
<body>
<h1> Lista Film</h1>

<c:forEach items="${listaFilm}" var="film">
				
		<form action="dettaglio-film" method="get">
	

		<h1> ${film.titolo}</h1>

	<h3> ${film.anno} </h3>
	
	<!-- genere value (?) -->
	<h3>${film.genere.value}</h3>
	<input type="hidden" name="filmId" value="${film.id}">
	<input type="submit" value="vai a dettaglio film">
</form>
	</c:forEach>
</body>
</html>