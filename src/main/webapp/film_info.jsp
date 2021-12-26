<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- TAGLIB CORE <3  -->   
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////// -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Film info</title>
</head>
<body>

	<h1>Titolo: ${film.titolo}</h1>

	<h3>Anno: ${film.anno} </h3>
	
	<h3>Durata: ${film.durata}</h3>
	
	<br>
	<br>
	<h3>Descrizione: </h3>
	<p>${film.descrizione}</p>
	<br>
	<br>
	<h3>Distribuzione: ${film.distribuzione}</h3>

	<h3>Paese: ${film.paese}</h3>
	
	<h3>Data di Uscita: ${film.dataDiUscita}</h3>
	
	<br>
	<br>
	<!-- genere value (?) -->
	<h3>Genere: ${film.genere.value}</h3>

	<h3>Regista: ${film.regista.nome} ${film.regista.cognome} </h3>
	<br>
	<br>
	<h3>Cast: </h3>
	<!-- 
	<p>${film.attori}</p>  -->
	<c:forEach items="${film.attori}" var="cast">
		<p>${cast.attore.nome} ${cast.attore.cognome} interpreta <i>${cast.nomeRuolo}</i></p>
	</c:forEach>
	 
</body>
</html>