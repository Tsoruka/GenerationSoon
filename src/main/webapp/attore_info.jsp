<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- TAGLIB CORE <3  -->   
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////// -->

<!DOCTYPE html>
<html>
<head>
<style>
.p{
 color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>Attore info</title>
</head>
<body>

<%@ include file="navbar.jsp" %>

	
	<div class ="p">
	<p style="text-align: justify;" >
	<img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQynIAJReBEhr6FGTQHQkIo0jmfWLY07G0J7qMOUQow9hBHf-Ad" width="400px" height="500px"  style="float: left; margin-right: 10px; margin-bottom: 10px;"/>
	<h1>Nome: ${attore.nome} ${attore.cognome}</h1>
	<h3>Data di nascita: ${attore.dataDiNascita}</h3>
	<h3>Luogo di nascita: ${attore.luogoDiNascita}</h3>
	<h3>Data di decesso: ${attore.dataDiDecesso}</h3>
	<h3>Biografia: ${attore.biografia}</h3>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h3>Film: </h3>
	<c:forEach items="${attore.film}" var="presente">
		<form action="dettaglio-film" method="get">
		<button style="cursor:pointer;" type="submit">
		<p>${presente.film.titolo} </p>
			<img src="${presente.film.foto}" width="400px" height="500px">
			<input type="hidden" name="filmId" value="${presente.film.id}">
		</button>
		</form>	
	</c:forEach>
	</div>	
	
</body>
</html>